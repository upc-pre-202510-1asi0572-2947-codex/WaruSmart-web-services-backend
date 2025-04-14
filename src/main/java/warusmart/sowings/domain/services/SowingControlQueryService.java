package warusmart.sowings.domain.services;

import warusmart.sowings.domain.model.entities.SowingControl;
import warusmart.sowings.domain.model.queries.GetAllSowingControlsQuery;
import warusmart.sowings.domain.model.queries.GetSowingControlsBySowingIdQuery;

import java.util.List;

public interface SowingControlQueryService {
    List<SowingControl> handle(GetAllSowingControlsQuery query);
    List<SowingControl> handle(GetSowingControlsBySowingIdQuery query);
}
