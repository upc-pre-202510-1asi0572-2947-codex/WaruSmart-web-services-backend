package warusmart.products.domain.model.services;

import warusmart.products.domain.model.commands.CreateProductCommand;
import warusmart.products.domain.model.commands.DeleteProductCommand;

public interface ProductCommandService {
    Long handle(CreateProductCommand command);
    void handle(DeleteProductCommand command);
}
