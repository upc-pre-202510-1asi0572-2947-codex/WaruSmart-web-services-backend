package warusmart.products.interfaces.rest.transform;

import warusmart.products.domain.model.commands.CreateProductCommand;
import warusmart.products.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.name(), resource.description(), resource.productType());
    }
}
