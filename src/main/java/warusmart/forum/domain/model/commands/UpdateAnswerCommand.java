package warusmart.forum.domain.model.commands;

public record UpdateAnswerCommand(Long answerId, String answerText) {
}
