package warusmart.users.interfaces.rest.transform;

import warusmart.users.domain.model.command.CreateUserCommand;
import warusmart.users.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.firstName(), resource.lastName(), resource.email(), resource.password(), resource.cityId(), resource.subscriptionId());
    }
}
