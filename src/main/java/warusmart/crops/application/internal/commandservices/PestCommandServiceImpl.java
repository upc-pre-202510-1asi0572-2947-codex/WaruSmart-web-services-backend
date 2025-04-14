package warusmart.crops.application.internal.commandservices;

import warusmart.crops.domain.model.commands.CreatePestCommand;
import warusmart.crops.domain.model.entities.Pest;
import warusmart.crops.domain.services.PestCommandService;
import warusmart.crops.infrastructure.persistence.jpa.repositories.PestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PestCommandServiceImpl implements PestCommandService {

    private final PestRepository pestRepository;

    @Autowired
    public PestCommandServiceImpl(PestRepository pestRepository) {
        this.pestRepository = pestRepository;
    }

    @Override
    public Long handle(CreatePestCommand command) {
        Pest pest = new Pest(command.name(), command.description(), command.solution(), command.cropId());
        pest = pestRepository.save(pest);
        return pest.getId();
    }
}
