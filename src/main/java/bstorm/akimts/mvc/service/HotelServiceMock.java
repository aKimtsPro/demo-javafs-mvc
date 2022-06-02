package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.form.HotelForm;
import bstorm.akimts.mvc.models.form.HotelUpdateForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;


@Qualifier("mock")
@Profile("dev")
@Service("hs_mock")
public class HotelServiceMock implements HotelService {
    @Override
    public List<HotelDTO> getAll() {
        return List.of(
                new HotelDTO(1, "nom", "adresse", 5, null)
        );
    }

    @Override
    public HotelDTO getOne(long id) {
        return new HotelDTO(id, "nom", "adresse", 5, null);
    }

    @Override
    public long insert(HotelForm form) {
        return 1;
    }

    @Override
    public void update(long id, HotelUpdateForm form) {
        // rien
    }
}
