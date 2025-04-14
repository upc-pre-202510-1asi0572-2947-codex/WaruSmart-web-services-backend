package warusmart.forum.interfaces.rest.transform;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.interfaces.rest.resources.QuestionResource;

public class QuestionResourceFromEntityAssembler {
    public static QuestionResource toResourceFromEntity(Question entity) {
        return new QuestionResource(
                entity.getId(),
                entity.getCategory(),
                entity.getUserId().userId(),
                entity.getQuestionText()
        );
    }

}
