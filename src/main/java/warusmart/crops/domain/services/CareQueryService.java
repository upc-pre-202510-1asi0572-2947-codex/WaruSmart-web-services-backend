package warusmart.crops.domain.services;

import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.domain.model.queries.GetAllCaresQuery;
import warusmart.crops.domain.model.queries.GetCaresByCropIdQuery;

import java.util.List;
import java.util.Optional;

public interface CareQueryService {
    List<Care> handle(GetAllCaresQuery query);

    Optional<Care> handle(GetCaresByCropIdQuery query);

    Optional<Care> findById(Long careId);

    List<Care> findByCropId(Long cropId);

}
