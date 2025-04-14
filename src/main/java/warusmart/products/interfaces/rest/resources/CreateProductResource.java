package warusmart.products.interfaces.rest.resources;

import warusmart.products.domain.model.valueobjects.ProductType;

public record CreateProductResource(String name, String description, ProductType productType) {
}
