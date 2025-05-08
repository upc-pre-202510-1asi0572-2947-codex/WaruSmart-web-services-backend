package warusmart.crops.domain.services;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.domain.model.queries.GetAllCropsQuery;
import warusmart.crops.domain.model.queries.GetCaresByCropIdQuery;
import warusmart.crops.domain.model.queries.GetCropByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CropQueryService {
    List<Crop> handle(GetAllCropsQuery query);
    Optional<Crop> handle(GetCropByIdQuery query);
    //Make this method abstract
    // and remove the implementation from the class
    Optional<Crop> findById(Long id);

    Optional<Care> handle(GetCaresByCropIdQuery query);
}