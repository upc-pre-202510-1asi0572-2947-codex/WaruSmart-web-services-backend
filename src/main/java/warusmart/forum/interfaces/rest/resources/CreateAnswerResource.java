package warusmart.forum.interfaces.rest.resources;

public record CreateAnswerResource(Long userId, Long questionId,String answerText) {
}
