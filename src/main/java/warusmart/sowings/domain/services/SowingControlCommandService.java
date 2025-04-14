package warusmart.sowings.domain.services;

import warusmart.sowings.domain.model.commands.CreateSowingControlCommand;

public interface SowingControlCommandService {
    Long handle(CreateSowingControlCommand command);

}
