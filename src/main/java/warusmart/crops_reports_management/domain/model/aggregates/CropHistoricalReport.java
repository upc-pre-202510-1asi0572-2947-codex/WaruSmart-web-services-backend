package warusmart.crops_reports_management.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import warusmart.sowings.domain.model.aggregates.Sowing;

@Entity
public class CropHistoricalReport {
    @Id
    private Long id;

    @ManyToOne
    private Sowing sowing;

    @Getter
    private String status;
    @Getter
    private float yieldEstimate;
    @Getter
    private float waterUsage;

}
