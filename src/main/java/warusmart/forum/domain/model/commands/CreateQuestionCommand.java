package warusmart.forum.domain.model.commands;



public record CreateQuestionCommand(String category, Long userId, String questionText) {
}
