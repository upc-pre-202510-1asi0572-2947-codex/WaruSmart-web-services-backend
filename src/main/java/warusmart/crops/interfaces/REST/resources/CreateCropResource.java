package warusmart.crops.interfaces.REST.resources;

import java.util.List;

    public record CreateCropResource(String name, String description, List<Long> diseases, List<Long> pests) {
}