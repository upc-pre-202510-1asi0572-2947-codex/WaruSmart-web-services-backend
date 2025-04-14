package warusmart.crops.domain.model.services;

import warusmart.crops.domain.model.commands.CreateCropCommand;

public interface CropCommandService {
    Long handle(CreateCropCommand command);
}
