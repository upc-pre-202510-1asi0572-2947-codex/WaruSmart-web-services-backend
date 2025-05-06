package warusmart.crops.interfaces.REST;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.queries.GetAllDiseasesQuery;
import warusmart.crops.domain.model.queries.GetDiseasesByCropIdQuery;
import warusmart.crops.domain.services.CropCommandService;
import warusmart.crops.domain.services.DiseaseCommandService;
import warusmart.crops.domain.services.DiseaseQueryService;
import warusmart.crops.interfaces.REST.resources.CreateDiseaseResource;
import warusmart.crops.interfaces.REST.resources.DiseaseResource;
import warusmart.crops.domain.services.CropQueryService;
import warusmart.crops.interfaces.REST.transform.CreateDiseaseCommandFromResourceAssembler;
import warusmart.crops.interfaces.REST.transform.DiseaseResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/diseases")
public class DiseaseController {

    private final DiseaseCommandService diseaseCommandService;
    private final DiseaseQueryService diseaseQueryService;
    private final CropQueryService cropQueryService;
    private final CropCommandService cropCommandService;

    public DiseaseController(DiseaseCommandService diseaseCommandService, DiseaseQueryService diseaseQueryService, CropQueryService cropQueryService, CropCommandService cropCommandService) {
        this.diseaseCommandService = diseaseCommandService;
        this.diseaseQueryService = diseaseQueryService;
        this.cropQueryService = cropQueryService;
        this.cropCommandService = cropCommandService;
    }

    @PostMapping
    public ResponseEntity<DiseaseResource> createDisease(@RequestBody CreateDiseaseResource resource) {
        var createDiseaseCommand = CreateDiseaseCommandFromResourceAssembler.toCommandFromResource(resource);
        Crop crop = cropQueryService.findById(createDiseaseCommand.cropId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Crop not found"));

        Long diseaseId = diseaseCommandService.handle(createDiseaseCommand);
        DiseaseResource diseaseResource = new DiseaseResource(diseaseId, resource.name(), resource.description(), resource.solution(), resource.cropId());

        crop.addDisease(diseaseQueryService.findById(diseaseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disease not found")));

        cropCommandService.save(crop);

        return new ResponseEntity<>(diseaseResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiseaseResource>> getAllDiseases() {
        var getAllDiseasesQuery = new GetAllDiseasesQuery();
        var diseases = diseaseQueryService.handle(getAllDiseasesQuery);
        var diseaseResource = diseases.stream().map(DiseaseResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(diseaseResource);
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<List<DiseaseResource>> getDiseasesByCropId(@PathVariable Long cropId) {
        var getDiseasesByCropIdQuery = new GetDiseasesByCropIdQuery(cropId);
        var diseases = diseaseQueryService.handle(getDiseasesByCropIdQuery);
        if(diseases.isEmpty()) return ResponseEntity.badRequest().build();
        var diseaseResources = diseases.stream()
                .map(disease -> new DiseaseResource(disease.getId(), disease.getName(), disease.getDescription(), disease.getSolution(), disease.getCropId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(diseaseResources);
    }
}