package warusmart.forum.interfaces.rest.resources;



public record CreateQuestionResource(Long userId,String category, String questionText) {
}
