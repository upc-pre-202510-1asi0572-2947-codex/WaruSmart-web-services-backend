package warusmart.sowings.application.internal.queryservices;

import warusmart.sowings.domain.model.entities.SowingControl;
import warusmart.sowings.domain.model.queries.GetAllSowingControlsQuery;
import warusmart.sowings.domain.model.queries.GetSowingControlsBySowingIdQuery;
import warusmart.sowings.domain.services.SowingControlQueryService;
import warusmart.sowings.infrastructure.persistence.jpa.repositories.SowingControlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SowingControlQueryServiceImpl implements SowingControlQueryService {

    private final SowingControlRepository sowingControlRepository;

    public SowingControlQueryServiceImpl(SowingControlRepository sowingControlRepository) {
        this.sowingControlRepository = sowingControlRepository;
    }

    @Override
    public List<SowingControl> handle(GetAllSowingControlsQuery query) {
        return sowingControlRepository.findAll();
    }

    @Override
    public List<SowingControl> handle(GetSowingControlsBySowingIdQuery query) {
        return sowingControlRepository.findBySowingId(query.sowingId());
    }
}