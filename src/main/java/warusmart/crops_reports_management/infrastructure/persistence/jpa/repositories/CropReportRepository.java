package warusmart.crops_reports_management.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import warusmart.crops_reports_management.domain.model.aggregates.CropReport;

import java.util.List;

public interface CropReportRepository extends JpaRepository<CropReport, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find reports by status or other criteria
    // List<CropReport> findByStatus(String status);

    List<CropReport> findCropReportById(Long id);

    List<CropReport> findCropReportBySowingId(Long sowingId);
}
