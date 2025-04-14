package warusmart.forum.domain.services;

import warusmart.forum.domain.model.aggregates.Answer;
import warusmart.forum.domain.model.queries.GetAllAnswersQuery;
import warusmart.forum.domain.model.queries.GetAllAnswersByQuestionIdQuery;
import warusmart.forum.domain.model.queries.GetAnswerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AnswerQueryService {
    List<Answer> handle(GetAllAnswersByQuestionIdQuery query);
    List<Answer> handle(GetAllAnswersQuery query);
    Optional<Answer> handle(GetAnswerByIdQuery query);
}
