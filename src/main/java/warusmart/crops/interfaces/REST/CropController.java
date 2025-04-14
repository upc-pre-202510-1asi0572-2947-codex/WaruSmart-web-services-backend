package warusmart.crops.interfaces.REST;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.entities.Disease;
import warusmart.crops.domain.model.entities.Pest;
import warusmart.crops.domain.model.queries.GetAllCropsQuery;
import warusmart.crops.domain.model.queries.GetCropByIdQuery;
import warusmart.crops.domain.services.CropCommandService;
import warusmart.crops.domain.services.CropQueryService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import warusmart.crops.infrastructure.persistence.jpa.repositories.DiseaseRepository;
import warusmart.crops.infrastructure.persistence.jpa.repositories.PestRepository;
import warusmart.crops.interfaces.REST.resources.CreateCropResource;
import warusmart.crops.interfaces.REST.resources.CropResource;
import warusmart.crops.interfaces.REST.resources.UpdateCropResource;
import warusmart.crops.interfaces.REST.transform.CropResourceFromEntityAssembler;
import warusmart.crops.interfaces.REST.transform.UpdateCropCommandFromResourceAssembler;
import warusmart.crops.domain.model.commands.DeleteCropCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/crops")  
public class CropController {

    private final CropCommandService cropCommandService;
    private final CropQueryService cropQueryService;

    @Autowired
    private CropRepository cropRepository;


    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private PestRepository pestRepository;

    public CropController(CropCommandService cropCommandService, CropQueryService cropQueryService) {
        this.cropCommandService = cropCommandService;
        this.cropQueryService = cropQueryService;
    }

    @PostMapping
    public ResponseEntity<CropResource> createCrop(@RequestBody CreateCropResource resource) {
        Set<Disease> diseases = resource.diseases().stream()
                .map(diseaseId -> diseaseRepository.findById(Math.toIntExact(diseaseId))
                        .orElseThrow(() -> new NoSuchElementException("Disease not found")))
                .collect(Collectors.toSet());

        Set<Pest> pests = resource.pests().stream()
                .map(pestId -> pestRepository.findById(Math.toIntExact(pestId))
                        .orElseThrow(() -> new NoSuchElementException("Pest not found")))
                .collect(Collectors.toSet());

        Crop crop = new Crop(resource.name(), resource.description(), diseases, pests);
        cropRepository.save(crop);

        CropResource cropResourceResponse = CropResourceFromEntityAssembler.toResourceFromEntity(crop);
        return ResponseEntity.ok(cropResourceResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CropResource> getCrop(@PathVariable Long id) {
        return cropQueryService.handle(new GetCropByIdQuery(id))
                .map(crop -> new CropResource(crop.getId(), crop.getName(), crop.getDescription(), crop.getDiseaseIds(), crop.getPestIds()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CropResource>> getAllCrops() {
        var getAllCropsQuery = new GetAllCropsQuery();
        var crops = cropQueryService.handle(getAllCropsQuery);
        var cropResources = crops.stream().map(CropResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(cropResources);
    }

    @PutMapping("/{cropId}")
    public ResponseEntity<CropResource> updateCrop(@PathVariable Long cropId, @RequestBody UpdateCropResource updateCropResource) {
        var updateCropCommand = UpdateCropCommandFromResourceAssembler.toCommandFromResource(cropId, updateCropResource);
        var updatedCrop = cropCommandService.handle(updateCropCommand);
        if (updatedCrop.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var cropResource = CropResourceFromEntityAssembler.toResourceFromEntity(updatedCrop.get());
        return ResponseEntity.ok(cropResource);
    }

    @DeleteMapping("/{cropId}")
    public ResponseEntity<?> deleteCrop(@PathVariable Long cropId) {
        var deleteCropCommand = new DeleteCropCommand(cropId);
        cropCommandService.handle(deleteCropCommand);
        return ResponseEntity.ok("Crop with given id successfully deleted");
    }

}