package warusmart.products.interfaces.rest.resources;

import warusmart.products.domain.model.valueobjects.ProductType;

public record ProductResource(Long id, String name,  String description, ProductType productType) {
}
