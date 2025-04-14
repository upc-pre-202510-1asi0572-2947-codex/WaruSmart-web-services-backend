package warusmart.crops.application.internal.queryservices;

import warusmart.crops.domain.model.entities.Disease;
import warusmart.crops.domain.model.queries.GetAllDiseasesQuery;
import warusmart.crops.domain.model.queries.GetDiseasesByCropIdQuery;
import warusmart.crops.domain.services.DiseaseQueryService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import warusmart.crops.infrastructure.persistence.jpa.repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseQueryServiceImpl implements DiseaseQueryService {

    private final DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseQueryServiceImpl(DiseaseRepository diseaseRepository, CropRepository cropRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public List<Disease> handle(GetAllDiseasesQuery query) {
        return diseaseRepository.findAll();
    }

    @Override
    public List<Disease> handle(GetDiseasesByCropIdQuery query) {
        return diseaseRepository.findByCropId(query.cropId());
    }

    @Override
    public Optional<Disease> findById(Long diseaseId) {
        return diseaseRepository.findById(Math.toIntExact(diseaseId));
    }

}