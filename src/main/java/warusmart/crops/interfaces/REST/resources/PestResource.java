package warusmart.crops.interfaces.REST.resources;

public record PestResource(Long id, String name, String description, String solution, Long cropId) {
}