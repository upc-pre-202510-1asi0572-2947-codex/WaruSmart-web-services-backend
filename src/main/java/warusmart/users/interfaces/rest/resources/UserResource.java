package warusmart.users.interfaces.rest.resources;

public record UserResource(Long id, String firstName,
                           String lastName,
                           String email,
                           String password,
                           Long cityId,
                           Long subscriptionId) {

}
