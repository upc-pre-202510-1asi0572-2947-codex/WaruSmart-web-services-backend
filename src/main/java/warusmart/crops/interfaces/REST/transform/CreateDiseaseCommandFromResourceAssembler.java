package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.interfaces.REST.resources.CreateDiseaseResource;
import warusmart.crops.domain.model.commands.CreateDiseaseCommand;

public class CreateDiseaseCommandFromResourceAssembler {

    public static CreateDiseaseCommand toCommandFromResource(CreateDiseaseResource resource) {
        return new CreateDiseaseCommand(
                resource.name(),
                resource.description(),
                resource.solution(),
                resource.cropId()
        );
    }
}