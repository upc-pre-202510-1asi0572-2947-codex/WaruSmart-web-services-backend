package open.source.agriculture.chaquitaclla.chaquitacllaplatformopen.crops.application.internal.queryservices;

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

    private final CropRepository cropRepository;

    public CropQueryServiceImpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }



    @Override
    public Optional<Care> handle(GetCaresByCropIdQuery query) {
        return cropRepository.findCareByCropId(query.cropId());
    }
}
    public List<Crop> handle(GetAllCropsQuery query) {
        return cropRepository.findAll();
    }

    @Override
    public Optional<Crop> handle(GetCropByIdQuery query) {
        return cropRepository.findById(query.id());
    }

    @Override
    public Optional<Crop> findById(Long id) {
        return cropRepository.findById(id);
    }
}
