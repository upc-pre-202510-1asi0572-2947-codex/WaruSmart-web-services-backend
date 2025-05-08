package warusmart.crops.application.internal.commandservices;

import org.springframework.stereotype.Service;
import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.commands.CreateCropCommand;
import warusmart.crops.domain.model.commands.DeleteCropCommand;
import warusmart.crops.domain.model.commands.UpdateCropCommand;
import warusmart.crops.domain.services.CropCommandService;

import java.util.Optional;

@Service
public class CropCommandServiceImpl implements CropCommandService {

    @Override
    public Long handle(CreateCropCommand command) {
        return 0L;
    }

    @Override
    public Optional<Crop> handle(UpdateCropCommand command) {
        return Optional.empty();
    }

    @Override
    public void handle(DeleteCropCommand command) {

    }

    @Override
    public void save(Crop crop) {

    }
}
