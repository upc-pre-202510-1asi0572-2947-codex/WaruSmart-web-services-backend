package warusmart.crops.domain.services;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.queries.GetAllCropsQuery;
import warusmart.crops.domain.model.queries.GetCropByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CropQueryService {
    List<Crop> handle(GetAllCropsQuery query);
    Optional<Crop> handle(GetCropByIdQuery query);
    Optional<Crop> findById(Long id);
}