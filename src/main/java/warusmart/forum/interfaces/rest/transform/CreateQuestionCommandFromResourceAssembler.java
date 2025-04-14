package warusmart.forum.interfaces.rest.transform;

import warusmart.forum.domain.model.commands.CreateQuestionCommand;
import warusmart.forum.interfaces.rest.resources.CreateQuestionResource;

public class CreateQuestionCommandFromResourceAssembler {
    public static CreateQuestionCommand toCommandFromResource(CreateQuestionResource resource){
        return new CreateQuestionCommand(
                resource.category(),
                resource.userId(),
                resource.questionText()
        );
    }
}
