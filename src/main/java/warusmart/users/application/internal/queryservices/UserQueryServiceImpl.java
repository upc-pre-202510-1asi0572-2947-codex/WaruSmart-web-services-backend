package warusmart.users.application.internal.queryservices;

import warusmart.users.domain.model.aggregates.User;
import warusmart.users.domain.model.queries.GetUserByEmailAndPasswordQuery;
import warusmart.users.domain.model.queries.GetUserByEmailQuery;
import warusmart.users.domain.model.services.UserQueryService;
import warusmart.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByEmailAndPasswordQuery query) {
        if (this.userRepository.existsByEmailAndPassword(query.email(), query.password())) {
            return this.userRepository.findByEmail(query.email());
        }
        else{
            throw new IllegalArgumentException("Password o email incorrect");
        }
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        if (this.userRepository.existsByEmail(query.email())) {
            throw new IllegalArgumentException("El correo electrónico ya está en uso, por favor ingresa otro");
        } else {
            return this.userRepository.findByEmail(query.email());
        }
    }
}
