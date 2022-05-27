package bstorm.akimts.mvc.utils;

import bstorm.akimts.mvc.models.entity.Hotel;
import bstorm.akimts.mvc.repository.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final HotelRepository repository;

    public DataInit(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Hotel> toInsert = List.of(
                new Hotel("petit hotel", "rue du petit hotel", 1),
                new Hotel("hotel luxueux", "rue de la thune", 5),
                new Hotel("hotel moyen", "rue bof", 3)
        );
        repository.saveAll(toInsert);
    }
}
