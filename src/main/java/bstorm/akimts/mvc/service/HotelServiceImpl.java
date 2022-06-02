package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.mapper.HotelMapper;
import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.entity.Hotel;
import bstorm.akimts.mvc.models.form.HotelForm;
import bstorm.akimts.mvc.models.form.HotelUpdateForm;
import bstorm.akimts.mvc.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("impl")
@Profile("prod")
@Service("hs_impl")
public class HotelServiceImpl implements HotelService {

//    @Autowired
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<HotelDTO> getAll(){
        return repository.findAll().stream()
                .map( mapper::toDto )
                .toList();
    }

    @Override
    public HotelDTO getOne(long id) {
        return repository.findById(id)
                .map( mapper::toDto )
                .orElseThrow();
    }

    @Override
    public long insert(HotelForm form) {
        Hotel entity = mapper.toEntity( form );
        entity = repository.save( entity );
        return entity.getId();
    }

    @Override
    public void update(long id, HotelUpdateForm form) {
        Hotel hotel = repository.findById(id)
                .orElseThrow();

        hotel.setNom(form.getNom());
        hotel.setNbrEtoiles(form.getNbrEtoiles());

        repository.save(hotel);
    }
}
