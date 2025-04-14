package warusmart.crops.domain.model.commands;

import java.util.List;

public record CreateCropCommand(String name, String description, List<Long> diseases, List<Long> pests) {
}
