package warusmart.sowings.domain.model.commands;

import warusmart.shared.domain.model.valueobjects.DateRange;

public record UpdateSowingCommand(Long sowingId, DateRange dateRange, int areaLand) {
}