package warusmart.forum.interfaces.rest.transform;

import warusmart.forum.domain.model.aggregates.Answer;
import warusmart.forum.interfaces.rest.resources.AnswerResource;

public class AnswerResourceFromEntityAssembler {
    public static AnswerResource toResourceFromEntity(Answer entity) {
        return new AnswerResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getQuestion().getId(),
                entity.getAnswerText()
        );

    }
}
