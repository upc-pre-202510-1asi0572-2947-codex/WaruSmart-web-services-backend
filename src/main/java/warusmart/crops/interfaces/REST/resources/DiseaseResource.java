package warusmart.crops.interfaces.REST.resources;

public record DiseaseResource(Long id, String name, String description, String solution, Long cropId) {
}