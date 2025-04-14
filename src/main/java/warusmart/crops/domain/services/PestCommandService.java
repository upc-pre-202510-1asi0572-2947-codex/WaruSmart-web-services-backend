package warusmart.crops.domain.services;

import warusmart.crops.domain.model.commands.CreatePestCommand;

public interface PestCommandService {
    Long handle(CreatePestCommand command);
}
