package bstorm.akimts.mvc.utils;

import bstorm.akimts.mvc.models.entity.Chambre;
import bstorm.akimts.mvc.models.entity.Hotel;
import bstorm.akimts.mvc.repository.ChambreRepository;
import bstorm.akimts.mvc.repository.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final HotelRepository repository;
    private final ChambreRepository cRepo;

    public DataInit(HotelRepository repository, ChambreRepository cRepo) {
        this.repository = repository;
        this.cRepo = cRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Hotel> toInsert = List.of(
                new Hotel(0,"petit hotel", "rue du petit hotel", 1, List.of()),
                new Hotel("hotel luxueux", "rue de la thune", 5),
                new Hotel("hotel moyen", "rue bof", 3)
        );
        repository.saveAll(toInsert);

        Chambre chambre = new Chambre();
        chambre.setNombreDeLits(2);
        chambre.setHotel( toInsert.get(0) );
        cRepo.save(chambre);
    }
}
