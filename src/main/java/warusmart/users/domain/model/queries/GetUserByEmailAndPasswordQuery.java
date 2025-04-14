package warusmart.users.domain.model.queries;

public record GetUserByEmailAndPasswordQuery(String email,
                                             String password)
{

}
