package warusmart.crops.interfaces.REST.resources;

public record CreatePestResource(String name, String description, String solution, Long cropId) {
}