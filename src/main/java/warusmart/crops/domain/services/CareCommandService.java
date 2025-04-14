package warusmart.crops.domain.services;

import warusmart.crops.domain.model.commands.CreateCareCommand;
import warusmart.crops.domain.model.entities.Care;

public interface CareCommandService {
    void createCare(CreateCareCommand command);

    Long handle(CreateCareCommand command);

    void save(Care care);

}