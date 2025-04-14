package warusmart.users.domain.model.services;

import warusmart.users.domain.model.aggregates.User;
import warusmart.users.domain.model.queries.GetUserByEmailAndPasswordQuery;
import warusmart.users.domain.model.queries.GetUserByEmailQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User>  handle(GetUserByEmailAndPasswordQuery query);
    Optional<User> handle(GetUserByEmailQuery query);
}
