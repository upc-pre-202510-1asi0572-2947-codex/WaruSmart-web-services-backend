package warusmart.crops_reports_management.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import warusmart.crops_reports_management.domain.model.commands.CreateCropReportCommand;
import warusmart.sowings.domain.model.aggregates.Sowing;

import java.util.Date;

/**
 * Class representing a report about a crop
 */
@Entity
public class CropReport {
    @Id
    @Getter
    private Long id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "sowing_id")
    private Sowing sowing;

    @Getter
    private Date date;

    @Getter
    private String status;

    @Getter
    private float yieldEstimate;

    @Getter
    private float waterUsage;

    public CropReport(CreateCropReportCommand command, Sowing sowing) {
        this.sowing = new Sowing();
        this.sowing = sowing;
        this.status = command.status();
        this.yieldEstimate = command.yieldEstimate();
        this.waterUsage = command.waterUsage();
    }


}
