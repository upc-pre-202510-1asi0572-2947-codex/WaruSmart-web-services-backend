package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.interfaces.REST.resources.DiseaseResource;
import warusmart.crops.domain.model.entities.Disease;

public class DiseaseResourceFromEntityAssembler {

    public static DiseaseResource toResourceFromEntity(Disease entity) {
        return new DiseaseResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getSolution(),
                entity.getCropId()
        );
    }
}