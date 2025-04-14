package warusmart.crops.infrastructure.persistence.jpa.repositories;

import warusmart.crops.domain.model.entities.Pest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PestRepository extends JpaRepository <Pest, Integer> {
    List<Pest> findByCropId(Long cropId);
}
