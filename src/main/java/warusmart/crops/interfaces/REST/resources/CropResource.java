package warusmart.crops.interfaces.REST.resources;

import java.util.List;

public record CropResource(Long id, String name, String description, List<Long> diseases, List<Long> pests) {
}
