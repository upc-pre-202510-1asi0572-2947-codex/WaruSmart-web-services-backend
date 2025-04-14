package warusmart.forum.domain.services;

import warusmart.forum.domain.model.aggregates.Answer;
import warusmart.forum.domain.model.commands.CreateAnswerCommand;
import warusmart.forum.domain.model.commands.DeleteAnswerCommand;
import warusmart.forum.domain.model.commands.UpdateAnswerCommand;

import java.util.Optional;

public interface AnswerCommandService {
    Long handle(CreateAnswerCommand command);
    Optional<Answer> handle(UpdateAnswerCommand command);
    void handle(DeleteAnswerCommand command);
}
