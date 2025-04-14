package warusmart.crops.interfaces.REST;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.domain.model.queries.GetAllCaresQuery;
import warusmart.crops.domain.services.CareCommandService;
import warusmart.crops.domain.services.CareQueryService;
import warusmart.crops.domain.services.CropCommandService;
import warusmart.crops.domain.services.CropQueryService;
import warusmart.crops.interfaces.REST.resources.CreateCareResource;
import warusmart.crops.interfaces.REST.resources.CareResource;
import warusmart.crops.interfaces.REST.transform.CareResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cares")
public class CareController {

    private final CareCommandService careCommandService;
    private final CareQueryService careQueryService;
    private final CropCommandService cropCommandService;
    private final CropQueryService cropQueryService;

    public CareController(CareCommandService careCommandService,
                          CareQueryService careQueryService,
                          CropCommandService cropCommandService,
                            CropQueryService cropQueryService) {
        this.careCommandService = careCommandService;
        this.careQueryService = careQueryService;
        this.cropCommandService = cropCommandService;
        this.cropQueryService = cropQueryService;
    }


    @PostMapping
    public ResponseEntity<CareResource> createCare(@RequestBody CreateCareResource careResource) {
        Crop crop = cropQueryService.findById(careResource.cropId())
                .orElseThrow(() -> new NoSuchElementException("Crop not found"));

        Care care = new Care(careResource.description(), crop);
        careCommandService.save(care);

        CareResource careResourceResponse = CareResourceFromEntityAssembler.toResourceFromEntity(care);
        return ResponseEntity.ok(careResourceResponse);
    }

    @GetMapping
    public ResponseEntity<List<CareResource>> getAllCares() {
        var getAllCaresQuery = new GetAllCaresQuery();
        var cares = careQueryService.handle(getAllCaresQuery);
        var careResource = cares.stream().map(CareResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(careResource);
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<List<CareResource>> getCaresByCropId(@PathVariable Long cropId) {
        List<Care> cares = careQueryService.findByCropId(cropId);
        if (cares.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<CareResource> careResources = cares.stream()
                .map(CareResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(careResources);
    }
}