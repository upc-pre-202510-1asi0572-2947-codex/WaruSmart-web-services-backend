package warusmart.sowings.domain.model.queries;

import warusmart.sowings.domain.model.valueobjects.PhenologicalPhase;

public record GetSowingsByPhenologicalPhaseQuery(PhenologicalPhase phase) {
}