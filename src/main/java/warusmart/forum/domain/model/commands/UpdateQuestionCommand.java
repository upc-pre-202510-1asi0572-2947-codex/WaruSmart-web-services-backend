package warusmart.forum.domain.model.commands;

public record UpdateQuestionCommand(Long questionId ,String category, String questionText) {
}
