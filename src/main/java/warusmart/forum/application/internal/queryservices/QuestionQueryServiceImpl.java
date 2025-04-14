package warusmart.forum.application.internal.queryservices;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.domain.model.queries.GetAllQuestionsByUserIdQuery;
import warusmart.forum.domain.model.queries.GetAllQuestionsQuery;
import warusmart.forum.domain.model.queries.GetQuestionByIdQuery;
import warusmart.forum.domain.services.QuestionQueryService;
import warusmart.forum.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionQueryServiceImpl implements QuestionQueryService {

    private final QuestionRepository questionRepository;

    public QuestionQueryServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Question> handle(GetAllQuestionsQuery query) {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> handle(GetAllQuestionsByUserIdQuery query) {
        return questionRepository.findByUserId(query.userId());    
    }

    @Override
    public Optional<Question> handle(GetQuestionByIdQuery query) {
        return questionRepository.findById(query.questionId());
    }
}
