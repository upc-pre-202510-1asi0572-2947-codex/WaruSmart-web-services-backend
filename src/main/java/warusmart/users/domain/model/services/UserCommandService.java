package warusmart.users.domain.model.services;

import warusmart.users.domain.model.command.CreateUserCommand;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
}
