package warusmart.crops.application.internal.queryservices;

import warusmart.crops.domain.model.aggregates.Crop;
import warusmart.crops.domain.model.entities.Care;
import warusmart.crops.domain.model.queries.GetAllCropsQuery;
import warusmart.crops.domain.model.queries.GetCaresByCropIdQuery;
import warusmart.crops.domain.model.queries.GetCropByIdQuery;
import warusmart.crops.domain.model.services.CropQueryService;

import warusmart.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropQueryServiceImpl implements CropQueryService {
    @Override
    public Optional<Crop> handle(GetCropByIdQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Crop> handle(GetAllCropsQuery query) {
        return List.of();
    }

    @Override
    public Optional<Care> handle(GetCaresByCropIdQuery query) {
        return Optional.empty();
    }
}
