package warusmart.users.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailDirection(String email) {
    //Constructor
    public EmailDirection(){
        this(null);
    }

    public  EmailDirection{
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

    }
    public String getEmailDirection() {
        return email;
    }


}
