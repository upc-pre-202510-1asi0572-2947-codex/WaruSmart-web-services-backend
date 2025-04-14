package warusmart.forum.domain.model.queries;


import warusmart.forum.domain.model.valueobjects.UserId;

public record GetAllQuestionsByUserIdQuery(UserId userId) {
}
