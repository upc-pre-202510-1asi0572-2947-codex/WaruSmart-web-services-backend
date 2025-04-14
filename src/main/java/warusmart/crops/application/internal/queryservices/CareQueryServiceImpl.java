package warusmart.crops.application.internal.queryservices;

import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.domain.model.queries.GetAllCaresQuery;
import warusmart.crops.domain.model.queries.GetCaresByCropIdQuery;
import warusmart.crops.domain.services.CareQueryService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.CareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareQueryServiceImpl implements CareQueryService {

    private final CareRepository careRepository;

    @Autowired
    public CareQueryServiceImpl(CareRepository careRepository) {
        this.careRepository = careRepository;
    }

    @Override
    public List<Care> handle(GetAllCaresQuery query) {
        return careRepository.findAll();
    }

    @Override
    public Optional<Care> handle(GetCaresByCropIdQuery query) {
        return careRepository.findById(query.cropId());
    }

    @Override
    public Optional<Care> findById(Long careId) {
        return careRepository.findById(careId);
    }

    @Override
    public List<Care> findByCropId(Long cropId) {
        return careRepository.findByCrop_Id(cropId);
    }

}