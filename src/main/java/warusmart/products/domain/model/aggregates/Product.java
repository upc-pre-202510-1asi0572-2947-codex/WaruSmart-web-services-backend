package warusmart.products.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import warusmart.products.domain.model.commands.CreateProductCommand;
import warusmart.products.domain.model.entities.ProductsSowings;
import warusmart.products.domain.model.valueobjects.ProductType;

import java.util.Set;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    Set<ProductsSowings> associations;

    public Product(CreateProductCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.productType = command.productType();
    }

}