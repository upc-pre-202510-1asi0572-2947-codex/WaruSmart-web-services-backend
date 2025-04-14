package warusmart.sowings.domain.model.commands;

import warusmart.shared.domain.model.valueobjects.DateRange;
import warusmart.sowings.domain.model.valueobjects.ProfileId;

public record CreateSowingCommand(DateRange dateRange, Long cropId, Integer areaLand, ProfileId profileId){
}
