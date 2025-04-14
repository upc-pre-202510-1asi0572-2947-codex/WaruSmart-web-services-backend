package warusmart.sowings.application.internal.commandservices;

import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.commands.CreateSowingCommand;
import warusmart.sowings.domain.model.commands.DeleteSowingCommand;
import warusmart.sowings.domain.model.commands.UpdateSowingCommand;
import warusmart.sowings.domain.services.SowingCommandService;
import warusmart.sowings.infrastructure.persistence.jpa.repositories.SowingRepository;
import warusmart.users.domain.model.aggregates.User;
import warusmart.users.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

public class SowingCommandServiceImpl implements SowingCommandService {
    private final SowingRepository sowingRepository;
    private final UserRepository userRepository;

    public SowingCommandServiceImpl(SowingRepository sowingRepository, UserRepository userRepository) {
        this.sowingRepository = sowingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateSowingCommand command) {
        Long profileIdLong = command.profileId().profileId(); // Assuming ProfileId has a getValue() method that returns Long
        User user = userRepository.findById(profileIdLong)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        var sowing = new Sowing(command.dateRange(), command.cropId().intValue(), user);
        sowingRepository.save(sowing);
        return sowing.getId();
    }
    @Override
    public Optional<Sowing> handle(UpdateSowingCommand command) {
        if (!sowingRepository.existsById(command.sowingId()))
            throw new IllegalArgumentException("Sowing does not exist");

        var sowingToUpdate = sowingRepository.findById(command.sowingId()).get();


        sowingToUpdate.setDateRange(command.dateRange());
        sowingToUpdate.setAreaLand(command.areaLand());

        var updatedSowing = sowingRepository.save(sowingToUpdate);

        return Optional.of(updatedSowing);
    }
    @Override
    public void handle(DeleteSowingCommand command) {
        if (!sowingRepository.existsById(command.sowingId()))
            throw new IllegalArgumentException("Sowing does not exist");

        sowingRepository.deleteById(command.sowingId());
    }
}
