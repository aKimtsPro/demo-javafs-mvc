package bstorm.akimts.mvc.models.dto;

import bstorm.akimts.mvc.models.entity.Hotel;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ChambreDTO {

    private long id;
    private long nbrLit;
    private HotelDTO hotel;

    @Data
    public class HotelDTO {

        private long hotelId;
        private String hotelName;
        private int nbrStars;

    }

}
