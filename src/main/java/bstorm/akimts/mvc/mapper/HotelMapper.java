package bstorm.akimts.mvc.mapper;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.entity.Hotel;
import bstorm.akimts.mvc.models.form.HotelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class HotelMapper {

    private final ChambreMapper cMapper;

    public HotelMapper(ChambreMapper cMapper) {
        this.cMapper = cMapper;
    }

    // ENTITY -> DTO
    public HotelDTO toDto(Hotel entity){
        if( entity == null )
            return null;

        return new HotelDTO(
                entity.getId(),
                entity.getNom(),
                entity.getAdresse(),
                entity.getNbrEtoiles(),
                entity.getChambres().stream()
                        .map( cMapper::toDto )
                        .toList()
        );
    }

    // FORM -> ENTITY
    public Hotel toEntity(HotelForm form){
        if( form == null )
            return null;

        return new Hotel(
                form.getNom(),
                form.getAdresse(),
                form.getNbrEtoiles()
        );
    }


}
