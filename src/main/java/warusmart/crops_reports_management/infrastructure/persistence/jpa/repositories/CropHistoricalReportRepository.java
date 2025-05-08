package warusmart.crops_reports_management.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import warusmart.crops_reports_management.domain.model.aggregates.CropHistoricalReport;

import java.util.Optional;

public interface CropHistoricalReportRepository extends JpaRepository<CropHistoricalReport, Long> {
    Optional<CropHistoricalReport> findBySowingId(Long sowingId);
}
