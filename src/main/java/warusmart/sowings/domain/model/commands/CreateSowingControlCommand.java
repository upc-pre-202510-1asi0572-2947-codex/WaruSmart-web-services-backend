package warusmart.sowings.domain.model.commands;
import warusmart.sowings.domain.model.valueobjects.SowingCondition;
import warusmart.sowings.domain.model.valueobjects.SowingSoilMoisture;
import warusmart.sowings.domain.model.valueobjects.SowingStemCondition;


public record CreateSowingControlCommand(Long sowingId,
                                         SowingCondition sowingCondition,
                                         SowingSoilMoisture sowingSoilMoisture,
                                         SowingStemCondition sowingStemCondition)
{
}