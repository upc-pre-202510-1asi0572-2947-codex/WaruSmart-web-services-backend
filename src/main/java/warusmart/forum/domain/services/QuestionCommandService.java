package warusmart.forum.domain.services;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.domain.model.commands.CreateQuestionCommand;
import warusmart.forum.domain.model.commands.DeleteQuestionCommand;
import warusmart.forum.domain.model.commands.UpdateQuestionCommand;

import java.util.Optional;

public interface QuestionCommandService {
    Long handle(CreateQuestionCommand command);
    Optional<Question> handle(UpdateQuestionCommand command);
    void handle(DeleteQuestionCommand command);


}
