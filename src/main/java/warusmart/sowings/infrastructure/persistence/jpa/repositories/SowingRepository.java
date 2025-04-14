package warusmart.sowings.infrastructure.persistence.jpa.repositories;

import warusmart.sowings.domain.model.aggregates.Sowing;
import warusmart.sowings.domain.model.valueobjects.PhenologicalPhase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SowingRepository extends JpaRepository<Sowing, Long>{
    List<Sowing> findByPhenologicalPhase(PhenologicalPhase phase);

}
