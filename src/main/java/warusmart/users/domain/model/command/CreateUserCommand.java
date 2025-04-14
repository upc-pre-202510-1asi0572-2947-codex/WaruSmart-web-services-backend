package warusmart.users.domain.model.command;

public record CreateUserCommand(String firstName,
                                String lastName,
                                String email,
                                String password,
                                Long cityId,
                                Long subscriptionId) {

}
