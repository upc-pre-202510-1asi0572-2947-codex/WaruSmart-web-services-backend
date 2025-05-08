package warusmart.crops_reports_management.domain.services;

import warusmart.crops_reports_management.domain.model.aggregates.CropReport;
import warusmart.crops_reports_management.domain.model.queries.GetAllReportsBySowingId;
import warusmart.crops_reports_management.domain.model.queries.GetCropReportByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CropReportQueryService {
    List<Optional<CropReport>> handle(GetAllReportsBySowingId query);

    Optional<CropReport> handle(GetCropReportByIdQuery query);
}
