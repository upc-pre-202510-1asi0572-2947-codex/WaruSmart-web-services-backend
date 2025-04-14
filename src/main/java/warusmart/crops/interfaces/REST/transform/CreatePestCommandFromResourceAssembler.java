package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.commands.CreatePestCommand;
import warusmart.crops.interfaces.REST.resources.CreatePestResource;

public class CreatePestCommandFromResourceAssembler {
    public static CreatePestCommand toCommandFromResource (CreatePestResource resource){
        return new CreatePestCommand(
                resource.name(),
                resource.description(),
                resource.solution(),
                resource.cropId()
        );
    }
}
