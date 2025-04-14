package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.commands.UpdateCropCommand;
import warusmart.crops.interfaces.REST.resources.UpdateCropResource;

public class UpdateCropCommandFromResourceAssembler {
    public static UpdateCropCommand toCommandFromResource(Long cropId, UpdateCropResource resource) {
        return new UpdateCropCommand(cropId, resource.name(), resource.description());
    }
}
