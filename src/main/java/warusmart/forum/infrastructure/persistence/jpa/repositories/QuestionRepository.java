package warusmart.forum.infrastructure.persistence.jpa.repositories;

import warusmart.forum.domain.model.aggregates.Question;
import warusmart.forum.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByUserId(UserId userId);
    boolean existsByQuestionText(String questionText);
}
