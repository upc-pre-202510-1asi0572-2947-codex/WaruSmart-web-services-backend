package warusmart.products.infrastructure.persistence.jpa.repositories;


import warusmart.products.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*Optional<Product> findByProductId(Long productId);
    List<Product> findProductsBySowingId(Long sowingId);*/
}
