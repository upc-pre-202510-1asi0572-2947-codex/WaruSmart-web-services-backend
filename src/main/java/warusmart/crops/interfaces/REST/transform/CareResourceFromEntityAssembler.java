package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.interfaces.REST.resources.CareResource;

public class CareResourceFromEntityAssembler {

    public static CareResource toResourceFromEntity(Care entity) {
        return new CareResource(entity.getId(), entity.getDescription(), entity.getCropId());
    }
}