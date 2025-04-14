package warusmart.crops.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import warusmart.crops.domain.model.aggregates.Crop;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Pest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private final Long cropId;

    @NotNull
    @Size(max = 30)
    private String Name;

    @NotNull
    @Size(max = 500)
    private String Description;

    @NotNull
    @Size(max = 500)
    private String Solution;

    @ManyToMany(mappedBy = "pests")
    private Set<Crop> crops = new HashSet<>();

    public Pest(String Name, String Description, String Solution, Long cropId){
        this.Name = Name;
        this.Description = Description;
        this.Solution = Solution;
        this.cropId = cropId;
    }
    public Pest(){
        this.cropId = null;
    }

}