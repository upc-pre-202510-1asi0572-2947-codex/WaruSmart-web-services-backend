package warusmart.crops.domain.services;

import warusmart.crops.domain.model.entities.Disease;
import warusmart.crops.domain.model.queries.GetAllDiseasesQuery;
import warusmart.crops.domain.model.queries.GetDiseasesByCropIdQuery;

import java.util.List;
import java.util.Optional;

public interface DiseaseQueryService {
    List<Disease> handle(GetAllDiseasesQuery query);
    List<Disease> handle(GetDiseasesByCropIdQuery query);
    Optional<Disease> findById(Long diseaseId);
}
