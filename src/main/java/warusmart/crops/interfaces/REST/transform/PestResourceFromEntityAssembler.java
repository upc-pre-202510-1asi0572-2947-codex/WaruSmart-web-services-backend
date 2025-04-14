package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.entities.Pest;
import warusmart.crops.interfaces.REST.resources.PestResource;

public class PestResourceFromEntityAssembler {
    public static PestResource toResourceFromEntity(Pest Entity){
        return new PestResource(
                Entity.getId(),
                Entity.getName(),
                Entity.getDescription(),
                Entity.getSolution(),
                Entity.getCropId()
        );
    }
}
