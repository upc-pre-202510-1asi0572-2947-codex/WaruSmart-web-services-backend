package warusmart.crops.domain.model.commands;

public record CreateDiseaseCommand(String name, String description, String solution, Long cropId) {
}
