package warusmart.sowings.application.internal.queryservices;

import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.queries.GetAllSowingsQuery;
import warusmart.sowings.domain.model.queries.GetSowingByIdQuery;
import warusmart.sowings.domain.model.queries.GetSowingsByPhenologicalPhaseQuery;
import warusmart.sowings.domain.services.SowingQueryService;
import warusmart.sowings.infrastructure.persistence.jpa.repositories.SowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SowingQueryServiceImpl implements SowingQueryService {

    private final SowingRepository sowingRepository;

    public SowingQueryServiceImpl(SowingRepository sowingRepository) {
        this.sowingRepository = sowingRepository;
    }

    @Override
    public List<Sowing> handle(GetAllSowingsQuery query) {
        return sowingRepository.findAll();
    }

    @Override
    public Optional<Sowing> handle(GetSowingByIdQuery query) {
        return sowingRepository.findById(query.id());
    }

    @Override
    public List<Sowing> handle(GetSowingsByPhenologicalPhaseQuery query) {
        return sowingRepository.findByPhenologicalPhase(query.phase());
    }
}