package warusmart.crops.domain.services;

import warusmart.crops.domain.model.commands.CreateDiseaseCommand;
import org.springframework.stereotype.Service;

@Service
public interface DiseaseCommandService {
    Long handle(CreateDiseaseCommand command);
}
