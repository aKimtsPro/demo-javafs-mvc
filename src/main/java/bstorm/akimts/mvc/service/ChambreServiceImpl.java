package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.exceptions.ElementNotFoundException;
import bstorm.akimts.mvc.models.entity.Chambre;
import bstorm.akimts.mvc.models.entity.Hotel;
import bstorm.akimts.mvc.models.form.ChambreInsertForm;
import bstorm.akimts.mvc.repository.ChambreRepository;
import bstorm.akimts.mvc.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements ChambreService{

    private final ChambreRepository cRep;
    private final HotelRepository hRep;

    public ChambreServiceImpl( ChambreRepository cRep, HotelRepository hRep) {
        this.cRep = cRep;
        this.hRep = hRep;
    }


    /**
     * Inserts a new Chambre to a Hotel
     * @param form containing relevent info for the insertion
     * @return the id of the inserted chambre
     * @throws NullPointerException if form is null
     * @throws ElementNotFoundException if an hotel wasn't found with the
     *          id present in the form
     */
    @Override
    public long insert(ChambreInsertForm form){
        Chambre c = form.toEntity();

        Optional<Hotel> opt = hRep.findById( form.getHotelId() );
        if( opt.isEmpty() )
            throw new ElementNotFoundException(form.getHotelId());

        Hotel h = opt.get();
        c.setHotel( h );
        c = cRep.save(c);

        return c.getId();
    }
}
