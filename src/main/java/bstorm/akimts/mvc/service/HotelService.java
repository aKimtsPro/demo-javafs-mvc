package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.form.HotelForm;

import java.util.List;

public interface HotelService {

    List<HotelDTO> getAll();
    HotelDTO getOne(long id);

    long insert(HotelForm form);

}
