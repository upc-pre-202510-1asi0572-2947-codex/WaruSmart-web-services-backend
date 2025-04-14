package warusmart.products.domain.model.commands;

import warusmart.products.domain.model.valueobjects.ProductType;

public record CreateProductCommand(String name, String description, ProductType productType) {
}