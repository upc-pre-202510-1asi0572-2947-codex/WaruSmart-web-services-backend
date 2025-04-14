package warusmart.sowings.domain.services;

import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.queries.GetAllSowingsQuery;
import warusmart.sowings.domain.model.queries.GetSowingByIdQuery;
import warusmart.sowings.domain.model.queries.GetSowingsByPhenologicalPhaseQuery;

import java.util.List;
import java.util.Optional;

public interface SowingQueryService {
    List<Sowing> handle(GetAllSowingsQuery query);
    Optional<Sowing> handle(GetSowingByIdQuery query);
    List<Sowing> handle(GetSowingsByPhenologicalPhaseQuery query);
}
