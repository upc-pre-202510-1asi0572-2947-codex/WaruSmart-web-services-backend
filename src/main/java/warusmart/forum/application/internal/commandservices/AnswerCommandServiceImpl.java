package warusmart.forum.application.internal.commandservices;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.domain.model.commands.CreateAnswerCommand;
import warusmart.forum.domain.model.aggregates.Answer;
import warusmart.forum.domain.model.commands.DeleteAnswerCommand;
import warusmart.forum.domain.model.commands.UpdateAnswerCommand;
import warusmart.forum.domain.services.AnswerCommandService;
import warusmart.forum.infrastructure.persistence.jpa.repositories.AnswerRepository;
import warusmart.forum.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerCommandServiceImpl implements AnswerCommandService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    public AnswerCommandServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public Long handle(CreateAnswerCommand command) {
        if (answerRepository.existsByAnswerTextAndQuestionId(command.answerText(), command.questionId()))
            throw new IllegalArgumentException("Answer with same answer text and questionId already exists");
        Optional<Question> optionalQuestion = questionRepository.findById(command.questionId());
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            Answer answer = new Answer(command.userId(), question, command.answerText());
            answerRepository.save(answer);
            return answer.getId();
        } else {
            throw new IllegalArgumentException("Question does not exist");
        }
    }

    @Override
    public Optional<Answer> handle(UpdateAnswerCommand command) {
        if(!answerRepository.existsById(command.answerId()))
            throw new IllegalArgumentException("Answer does not exist");
        var answerToUpdate = answerRepository.findById(command.answerId()).get();
        var updateAnswer = answerRepository.save(answerToUpdate.updateInformation(command.answerText()));
        return Optional.of(updateAnswer);
    }

    @Override
    public void handle(DeleteAnswerCommand command) {
        if(!answerRepository.existsById(command.answerId()))
            throw new IllegalArgumentException("Answer does not exist");
        answerRepository.deleteById(command.answerId());
    }
}
