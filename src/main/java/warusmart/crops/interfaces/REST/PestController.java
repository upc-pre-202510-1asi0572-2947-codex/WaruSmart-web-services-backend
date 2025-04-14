package warusmart.crops.interfaces.REST;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.entities.Pest;
import open.source.agriculture.chaquitaclla.chaquitacllaplatformopen.crops.domain.model.queries.*;
import warusmart.crops.domain.model.queries.GetAllPestsQuery;
import warusmart.crops.domain.services.CropCommandService;
import warusmart.crops.domain.services.PestCommandService;
import warusmart.crops.domain.services.PestQueryService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.PestRepository;
import warusmart.crops.interfaces.REST.resources.CreatePestResource;
import warusmart.crops.interfaces.REST.resources.PestResource;
import warusmart.crops.domain.services.CropQueryService;
import warusmart.crops.interfaces.REST.transform.CreatePestCommandFromResourceAssembler;
import warusmart.crops.interfaces.REST.transform.PestResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/pests")
public class PestController {

    private final PestCommandService pestCommandService;
    private final PestQueryService pestQueryService;
    private final CropQueryService cropQueryService;
    private final CropCommandService cropCommandService;

    @Autowired
    private PestRepository pestRepository;

    public PestController(PestCommandService pestCommandService, PestQueryService pestQueryService, CropQueryService cropQueryService, CropCommandService cropCommandService) {
        this.pestCommandService = pestCommandService;
        this.pestQueryService = pestQueryService;
        this.cropQueryService = cropQueryService;
        this.cropCommandService = cropCommandService;
    }

    @PostMapping
    public ResponseEntity<PestResource> createPest(@RequestBody CreatePestResource resource) {
        var createPestCommand = CreatePestCommandFromResourceAssembler.toCommandFromResource(resource);
        Crop crop = cropQueryService.findById(createPestCommand.cropId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Crop not found"));

        Long pestId = pestCommandService.handle(createPestCommand);
        PestResource pestResource = new PestResource(pestId, resource.name(), resource.description(), resource.solution(), resource.cropId());

        crop.addPest(pestQueryService.findById(pestId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pest not found")));

        cropCommandService.save(crop);

        return new ResponseEntity<>(pestResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PestResource>> getAllPests() {
        var getAllPestsQuery = new GetAllPestsQuery();
        var pests = pestQueryService.handle(getAllPestsQuery);
        var pestResource = pests.stream().map(PestResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(pestResource);
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<List<PestResource>> getPestsByCropId(@PathVariable Long cropId) {
        List<Pest> pests = pestRepository.findByCropId(cropId);
        if (pests.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PestResource> pestResources = pests.stream()
                .map(PestResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pestResources);
    }
}