package warusmart.crops.domain.model.commands;

public record UpdateCropCommand(Long cropId, String name, String description) {}