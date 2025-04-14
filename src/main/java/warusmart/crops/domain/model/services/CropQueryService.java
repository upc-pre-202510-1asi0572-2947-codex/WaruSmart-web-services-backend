package warusmart.crops.domain.model.services;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.domain.model.queries.GetAllCropsQuery;
import warusmart.crops.domain.model.queries.GetCaresByCropIdQuery;
import warusmart.crops.domain.model.queries.GetCropByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CropQueryService{
    Optional<Crop> handle(GetCropByIdQuery query);
    List<Crop> handle(GetAllCropsQuery query);
    Optional<Care> handle(GetCaresByCropIdQuery query);
}
