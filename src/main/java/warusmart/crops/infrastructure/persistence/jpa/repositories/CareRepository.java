package warusmart.crops.infrastructure.persistence.jpa.repositories;

import warusmart.crops.domain.model.entities.Care;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CareRepository extends JpaRepository<Care, Long> {
    List<Care> findByCrop_Id(Long cropId);
    Optional<Care> findById(Long id);

}