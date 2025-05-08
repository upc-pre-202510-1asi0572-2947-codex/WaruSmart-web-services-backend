package warusmart.crops_reports_management.domain.model.commands;

public record CreateHistoricalReportCommand(
        Long sowingId,
        String status,
        float yieldEstimate,
        float waterUsage
) {
}
