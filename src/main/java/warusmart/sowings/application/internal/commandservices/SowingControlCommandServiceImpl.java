package warusmart.sowings.application.internal.commandservices;

import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.commands.CreateSowingControlCommand;
import warusmart.sowings.domain.model.entities.SowingControl;
import warusmart.sowings.domain.services.SowingControlCommandService;
import warusmart.sowings.infrastructure.persistence.jpa.repositories.SowingControlRepository;
import warusmart.sowings.infrastructure.persistence.jpa.repositories.SowingRepository;
import org.springframework.stereotype.Service;

@Service
public class SowingControlCommandServiceImpl implements SowingControlCommandService {

    private final SowingRepository sowingRepository;
    private final SowingControlRepository sowingControlsRepository;

    public SowingControlCommandServiceImpl(SowingRepository sowingRepository, SowingControlRepository sowingControlsRepository) {
        this.sowingRepository = sowingRepository;
        this.sowingControlsRepository = sowingControlsRepository;
    }

    @Override
    public Long handle(CreateSowingControlCommand command) {
        Sowing sowing = sowingRepository.findById(command.sowingId())
                .orElseThrow(() -> new IllegalArgumentException("Sowing with id " + command.sowingId() + " does not exist"));

        var sowingControl = new SowingControl(sowing, command.sowingCondition(), command.sowingSoilMoisture(), command.sowingStemCondition());
        sowingControlsRepository.save(sowingControl);
        return sowingControl.getId();
    }
}