package warusmart.forum.interfaces.rest.transform;

import warusmart.forum.domain.model.commands.UpdateAnswerCommand;
import warusmart.forum.interfaces.rest.resources.UpdateAnswerResource;

public class UpdateAnswerCommandFromResourceAssembler {
    public static UpdateAnswerCommand toCommandFromResource(Long answerId, UpdateAnswerResource resource){
        return new UpdateAnswerCommand(
                answerId,
                resource.answerText()
        );
    }
}
