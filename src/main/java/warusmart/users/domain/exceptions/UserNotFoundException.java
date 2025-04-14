package warusmart.users.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long iLong) {
        super("User with id " + iLong + " not found");
    }
}
