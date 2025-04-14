package warusmart.crops.domain.services;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.commands.CreateCropCommand;
import warusmart.crops.domain.model.commands.DeleteCropCommand;
import warusmart.crops.domain.model.commands.UpdateCropCommand;

import java.util.Optional;

public interface CropCommandService {
    Long handle(CreateCropCommand command);
    Optional<Crop> handle(UpdateCropCommand command);
    void handle(DeleteCropCommand command);

    void save(Crop crop);
}