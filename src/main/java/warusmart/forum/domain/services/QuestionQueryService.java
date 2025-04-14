package warusmart.forum.domain.services;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.domain.model.queries.GetAllQuestionsByUserIdQuery;
import warusmart.forum.domain.model.queries.GetAllQuestionsQuery;
import warusmart.forum.domain.model.queries.GetQuestionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryService {
    List<Question> handle(GetAllQuestionsQuery query);
    List<Question> handle(GetAllQuestionsByUserIdQuery query);
    Optional<Question> handle(GetQuestionByIdQuery query);
}
