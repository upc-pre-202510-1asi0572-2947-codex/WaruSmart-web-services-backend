package warusmart.crops_reports_management.domain.services;

import warusmart.crops_reports_management.domain.model.commands.CreateCropReportCommand;

public interface CropReportCommandService {

    Long handle(CreateCropReportCommand command);
}
