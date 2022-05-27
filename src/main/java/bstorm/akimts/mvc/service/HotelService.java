package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.models.dto.HotelDTO;

import java.util.List;

public interface HotelService {

    List<HotelDTO> getAll();

    HotelDTO getOne(long id);

}
