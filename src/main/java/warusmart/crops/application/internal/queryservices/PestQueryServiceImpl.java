package warusmart.crops.application.internal.queryservices;

import warusmart.crops.domain.model.entities.Pest;
import warusmart.crops.domain.model.queries.GetAllPestsQuery;
import warusmart.crops.domain.model.queries.GetPestByCropIdQuery;
import warusmart.crops.domain.model.queries.GetPestByIdQuery;
import warusmart.crops.domain.services.PestQueryService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.PestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PestQueryServiceImpl implements PestQueryService {

    private final PestRepository pestRepository;

    @Autowired
    public PestQueryServiceImpl(PestRepository pestRepository) {
        this.pestRepository = pestRepository;
    }

    @Override
    public List<Pest> handle(GetAllPestsQuery query) {
        return pestRepository.findAll();
    }

    @Override
    public List<Pest> handle(GetPestByCropIdQuery query) {
        return pestRepository.findByCropId(query.cropId());
    }

    @Override
    public Optional<Pest> findById(Long pestId) {
        return pestRepository.findById(Math.toIntExact(pestId));
    }

    @Override
    public Optional<Pest> handle(GetPestByIdQuery query) {
        return pestRepository.findById(Math.toIntExact(query.id()));
    }
}
