package warusmart.forum.application.internal.commandservices;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.domain.model.commands.CreateQuestionCommand;
import warusmart.forum.domain.model.commands.DeleteQuestionCommand;
import warusmart.forum.domain.model.commands.UpdateQuestionCommand;
import warusmart.forum.domain.services.QuestionCommandService;
import warusmart.forum.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionCommandServiceImpl implements QuestionCommandService {

    private final QuestionRepository questionRepository;

    public QuestionCommandServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Long handle(CreateQuestionCommand command) {
        if(questionRepository.existsByQuestionText(command.questionText()))
            throw new IllegalArgumentException("Question already exists");
        var question = new Question(command.category(), command.userId(),command.questionText());
        questionRepository.save(question);
        return question.getId();
    }

    @Override
    public Optional<Question> handle(UpdateQuestionCommand command) {
        if(!questionRepository.existsById(command.questionId()))
            throw new IllegalArgumentException("Question does not exist");
        var questionToUpdate = questionRepository.findById(command.questionId()).get();
        var updateQuestion = questionRepository.save(questionToUpdate.updateInformation(command.category(),command.questionText()));
        return Optional.of(updateQuestion);
    }

    @Override
    public void handle(DeleteQuestionCommand command) {
        if(!questionRepository.existsById(command.questionId())){
            throw new IllegalArgumentException("Question does not exist");
        }
        questionRepository.deleteById(command.questionId());
    }
}
