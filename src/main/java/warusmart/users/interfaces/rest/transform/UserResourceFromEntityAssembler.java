package warusmart.users.interfaces.rest.transform;

import warusmart.users.domain.model.aggregates.User;
import warusmart.users.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getId(),
                user.getName().getFirstName(),
                user.getName().getLastName(),
                user.getEmail().getEmailDirection(),
                user.getPassword().getPassword(),
                user.getCityId(),
                user.getSubscriptionId()
        );
    }
}
