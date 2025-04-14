package warusmart.users.domain.model.entities;

import jakarta.persistence.*;
import warusmart.shared.domain.model.entities.AuditableModel;


@Entity
public class City extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    //contructor
    public City() {
    }
    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }



    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
}
