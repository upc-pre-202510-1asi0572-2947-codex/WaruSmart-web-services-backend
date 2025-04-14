package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.commands.CreateCropCommand;
import warusmart.crops.interfaces.REST.resources.CreateCropResource;


public class CreateCropCommandFromResourceAssembler {

    public static CreateCropCommand toCommandFromResource(CreateCropResource resource) {
        return new CreateCropCommand(
                resource.name(),
                resource.description(),
                resource.diseases(),
                resource.pests()
        );
    }
}