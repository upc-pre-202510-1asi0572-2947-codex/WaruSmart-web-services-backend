package warusmart.crops.interfaces.REST.transform;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.interfaces.REST.resources.CropResource;

public class CropResourceFromEntityAssembler {
    public static CropResource toResourceFromEntity(Crop entity) {
        return new CropResource(entity.getId(), entity.getName(), entity.getDescription(), entity.getDiseaseIds(), entity.getPestIds());
    }
}
