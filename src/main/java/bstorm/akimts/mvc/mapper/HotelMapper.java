package bstorm.akimts.mvc.mapper;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.entity.Hotel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HotelMapper {

    // ENTITY -> DTO
    public HotelDTO toDto(Hotel entity){
        if( entity == null )
            return null;

        return new HotelDTO(
                entity.getId(),
                entity.getNom(),
                entity.getAdresse(),
                entity.getNbrEtoiles()
        );
    }

    // FORM -> ENTITY

}
