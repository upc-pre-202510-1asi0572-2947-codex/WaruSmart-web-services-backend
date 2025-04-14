package warusmart.crops.infrastructure.persistence.jpa.repositories;

import warusmart.crops.domain.model.entities.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
    List<Disease> findByCropId(Long aLong);
}
