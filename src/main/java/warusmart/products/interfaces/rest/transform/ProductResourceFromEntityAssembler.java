package warusmart.products.interfaces.rest.transform;

import warusmart.products.domain.model.aggregates.Product;
import warusmart.products.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product) {
        return new ProductResource(product.getId(), product.getName(),  product.getDescription(), product.getProductType());
    }
}
