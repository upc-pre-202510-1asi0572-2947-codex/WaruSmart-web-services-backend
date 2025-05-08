package warusmart.crops_reports_management.domain.services;

import warusmart.crops_reports_management.domain.model.commands.CreateHistoricalReportCommand;

public interface CropHistoricalReportCommandService {

    Long handle(CreateHistoricalReportCommand command);
}
