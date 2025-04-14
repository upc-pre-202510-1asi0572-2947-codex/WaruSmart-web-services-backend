package warusmart.sowings.infrastructure.persistence.jpa.repositories;

import warusmart.sowings.domain.model.entities.SowingControl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SowingControlRepository extends JpaRepository<SowingControl, Long>{
    List<SowingControl> findBySowingId(Long aLong);
}
