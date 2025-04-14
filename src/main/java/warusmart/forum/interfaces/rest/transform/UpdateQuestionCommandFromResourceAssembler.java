package warusmart.forum.interfaces.rest.transform;

import warusmart.forum.domain.model.commands.UpdateQuestionCommand;
import warusmart.forum.interfaces.rest.resources.UpdateQuestionResource;

public class UpdateQuestionCommandFromResourceAssembler {
    public static UpdateQuestionCommand toCommandFromResource(Long questionId, UpdateQuestionResource resource){
        return new UpdateQuestionCommand(
                questionId,
                resource.category(),
                resource.questionText()
        );
    }
}
