package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.mapper.HotelMapper;
import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

//    @Autowired
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HotelDTO> getAll(){
        return repository.findAll().stream()
                .map( mapper::toDto )
                .toList();
    }

    @Override
    public HotelDTO getOne(long id) {
        // TODO: redefinir
        return null;
    }

}