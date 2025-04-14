package warusmart.crops.interfaces.REST.resources;

public record CreateDiseaseResource(String name, String description, String solution, Long cropId) {
}