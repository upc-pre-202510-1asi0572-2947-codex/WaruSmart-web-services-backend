package warusmart.crops.domain.services;

import warusmart.crops.domain.model.entities.Pest;
import warusmart.crops.domain.model.queries.GetAllPestsQuery;
import warusmart.crops.domain.model.queries.GetPestByCropIdQuery;
import warusmart.crops.domain.model.queries.GetPestByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PestQueryService {
    List<Pest> handle(GetAllPestsQuery query);
    List<Pest> handle(GetPestByCropIdQuery query);
    Optional<Pest> findById(Long pestId);
    Optional<Pest> handle(GetPestByIdQuery getPestByIdQuery);
}
