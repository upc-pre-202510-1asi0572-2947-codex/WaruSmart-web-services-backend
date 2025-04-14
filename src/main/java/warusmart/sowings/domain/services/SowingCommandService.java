package warusmart.sowings.domain.services;

import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.commands.CreateSowingCommand;
import warusmart.sowings.domain.model.commands.DeleteSowingCommand;
import warusmart.sowings.domain.model.commands.UpdateSowingCommand;

import java.util.Optional;

public interface SowingCommandService {
    Long handle(CreateSowingCommand command);
    Optional<Sowing> handle(UpdateSowingCommand command);
    void handle(DeleteSowingCommand command);

}
