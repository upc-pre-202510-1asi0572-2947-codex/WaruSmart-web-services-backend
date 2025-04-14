package warusmart.crops.domain.model.commands;

public record CreatePestCommand(String name, String description, String solution, Long cropId) {
}
