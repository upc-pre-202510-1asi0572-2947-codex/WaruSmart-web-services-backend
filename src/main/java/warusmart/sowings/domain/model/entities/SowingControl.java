package warusmart.sowings.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.valueobjects.SowingCondition;
import warusmart.sowings.domain.model.valueobjects.SowingSoilMoisture;
import warusmart.sowings.domain.model.valueobjects.SowingStemCondition;

import java.util.Date;

@Getter
@Setter
@Entity
@Embeddable
public class SowingControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sowing_id")
    @NotNull
    private Sowing sowing;

    private Date controlDate;

    @NotNull
    private SowingCondition sowingCondition;
    @NotNull
    private SowingSoilMoisture sowingSoilMoisture;
    @NotNull
    private SowingStemCondition sowingStemCondition;


    public SowingControl(Sowing sowing, SowingCondition sowingCondition,SowingSoilMoisture sowingSoilMoisture, SowingStemCondition sowingStemCondition) {
        this.sowing = sowing;
        this.sowingCondition = sowingCondition;
        this.sowingSoilMoisture = sowingSoilMoisture;
        this.sowingStemCondition= sowingStemCondition;
    }
    public SowingControl(){
    }

    public void controlCreated() {
        this.controlDate = new Date();
    }
}
