package bstorm.akimts.mvc.mapper;

import bstorm.akimts.mvc.models.dto.ChambreDTO;
import bstorm.akimts.mvc.models.entity.Chambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChambreMapper {


    public ChambreDTO toDto(Chambre entity){

        if( entity == null )
            return null;

        ChambreDTO dto = new ChambreDTO();

        dto.setId(entity.getId());
        dto.setNbrLit(entity.getNombreDeLits());

        ChambreDTO.HotelDTO hotelDTO = dto.new HotelDTO();

        hotelDTO.setHotelId( entity.getHotel().getId() );
        hotelDTO.setHotelName( entity.getHotel().getNom() );
        hotelDTO.setNbrStars( entity.getHotel().getNbrEtoiles() );

        dto.setHotel(hotelDTO);

        return dto;
    }

}
