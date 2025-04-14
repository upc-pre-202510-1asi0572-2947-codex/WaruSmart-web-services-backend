package warusmart.crops.application.internal.commandservices;

import warusmart.crops.domain.model.entities.Disease;
import warusmart.crops.domain.model.commands.CreateDiseaseCommand;
import warusmart.crops.domain.services.DiseaseCommandService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseCommandServiceImpl implements DiseaseCommandService {

    private final DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseCommandServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Long handle(CreateDiseaseCommand command) {
        Disease disease = new Disease(command.name(), command.description(), command.solution(), command.cropId());
        disease = diseaseRepository.save(disease);
        return disease.getId();
    }
}