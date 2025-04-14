package warusmart.products.domain.model.services;


import warusmart.products.domain.model.aggregates.Product;
import warusmart.products.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    /*List<Product> handle(GetProductsBySowingIdQuery query);*/
    Optional<Product> handle(GetProductByIdQuery query);
}
