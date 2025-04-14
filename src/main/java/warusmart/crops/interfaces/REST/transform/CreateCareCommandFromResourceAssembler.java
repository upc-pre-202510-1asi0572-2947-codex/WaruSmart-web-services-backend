package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.commands.CreateCareCommand;
import warusmart.crops.interfaces.REST.resources.CreateCareResource;

public class CreateCareCommandFromResourceAssembler {

    public static CreateCareCommand toCommandFromResource(CreateCareResource resource) {
        return new CreateCareCommand(
                resource.description(),
                resource.cropId()
        );
    }
}