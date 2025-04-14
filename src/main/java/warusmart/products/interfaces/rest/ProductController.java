package warusmart.products.interfaces.rest;

import warusmart.products.domain.model.commands.DeleteProductCommand;
import warusmart.products.domain.model.queries.GetProductByIdQuery;
import warusmart.products.domain.model.services.ProductCommandService;
import warusmart.products.domain.model.services.ProductQueryService;
import warusmart.products.interfaces.rest.resources.CreateProductResource;
import warusmart.products.interfaces.rest.resources.ProductResource;
import warusmart.products.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import warusmart.products.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products", produces = APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource resource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(resource);
        Long productId = productCommandService.handle(createProductCommand);
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResource> getProductById(@RequestParam Long id) {
        return productQueryService.handle(new GetProductByIdQuery(id))
                .map(product -> new ProductResource(product.getId(), product.getName(), product.getDescription(),product.getProductType()))
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    /*@GetMapping
    public ResponseEntity<?> getProductsBySowingId() {
            var getProductsBySowingIdQuery = new GetProductsBySowingIdQuery();
            var products = productQueryService.handle(getProductsBySowingIdQuery);
            var productResources = products.stream().map(ProductResourceFromEntityAssembler::toResourceFromEntity).toList();
            return ResponseEntity.ok(productResources);
    }*/


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        var deleteProductCommand = new DeleteProductCommand(id);
        productCommandService.handle(deleteProductCommand);
        return ResponseEntity.ok("Product with given id succesfully deleted.");
    }
}
