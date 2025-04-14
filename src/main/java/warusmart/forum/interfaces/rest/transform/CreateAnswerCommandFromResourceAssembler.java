package warusmart.forum.interfaces.rest.transform;

import warusmart.forum.domain.model.commands.CreateAnswerCommand;
import warusmart.forum.interfaces.rest.resources.CreateAnswerResource;

public class CreateAnswerCommandFromResourceAssembler {
    public static CreateAnswerCommand toCommandFromResource(CreateAnswerResource resource){
        return new CreateAnswerCommand(
                resource.userId(),
                resource.questionId(),
                resource.answerText()
        );

    }
}
