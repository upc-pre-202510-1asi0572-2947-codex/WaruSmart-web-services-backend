package warusmart.users.application.internal.commandservices;

import warusmart.users.domain.model.aggregates.User;
import warusmart.users.domain.model.command.CreateUserCommand;
import warusmart.users.domain.model.services.UserCommandService;
import warusmart.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService{
    private UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Long handle(CreateUserCommand command) {
        if(userRepository.existsByEmail(command.email())){
            throw new IllegalArgumentException("User with email already exists");
        }
        var user= new User(command.firstName(), command.lastName(), command.email(), command.password());
        this.userRepository.save(user);
        return user.getId();
    }
}
