package bstorm.akimts.mvc.controller;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.form.ChambreInsertForm;
import bstorm.akimts.mvc.models.form.HotelForm;
import bstorm.akimts.mvc.models.form.HotelUpdateForm;
import bstorm.akimts.mvc.service.ChambreService;
import bstorm.akimts.mvc.service.HotelService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;
    private final ChambreService chambreService;

    public HotelController(@Qualifier("impl") HotelService service, ChambreService cService) {
        this.hotelService = service;
        this.chambreService = cService;
    }

    // GET http://localhost:8080/hotel/all
    @GetMapping("/all")
    public String displayAll(Model model){
        List<HotelDTO> hotels = hotelService.getAll();
        model.addAttribute("hotels", hotels);
        return "hotel/displayAll";
    }

    // GET http://localhost:8080/hotel/5/details
    @GetMapping("/{id}/details")
    public String displayOne(
            @PathVariable long id,
            Model model,
            @ModelAttribute("roomForm") ChambreInsertForm form
    ){
        model.addAttribute("hotel", hotelService.getOne(id));
        form.setHotelId(id);
        return "hotel/displayOne";
    }

    // GET http://localhost:8080/hotel/add
    @GetMapping("/add")
    public String createForm( @ModelAttribute("hotel") HotelForm form ){
        return "hotel/insert";
    }

    // POST http://localhost:8080/hotel/add
    @PostMapping("/add")
    public String processCreate(@Valid @ModelAttribute("hotel") HotelForm form, BindingResult binding){

        if( binding.hasErrors() )
            return "hotel/insert";

        long id = hotelService.insert(form);
        return "redirect:/hotel/"+id+"/details";
    }

    // GET http://localhost:8080/hotel/{id}/update
    @GetMapping("/{id}/update")
    public String updateForm(
            @PathVariable @ModelAttribute long id,
            @ModelAttribute("hotel")HotelUpdateForm form
    ){
        HotelDTO dto = hotelService.getOne(id);

        form.setNom(dto.getNom());
        form.setNbrEtoiles(dto.getNbrEtoiles());

        return "hotel/update";
    }

    // POST http://localhost:8080/hotel/{id}/update
    @PostMapping("/{id}/update")
    public String processUpdate(@PathVariable long id, @ModelAttribute("hotel")HotelUpdateForm form){
        hotelService.update(id, form);
        return "redirect:/hotel/"+id+"/details";
    }


    @PostMapping("/add-room")
    public String processAddRoom(
            @Valid @ModelAttribute("roomForm") ChambreInsertForm form,
            BindingResult binding,
            Model model
    ){

        if( binding.hasErrors() )
            return displayOne(form.getHotelId(), model, form);

        chambreService.insert(form);
        return "redirect:/hotel/"+form.getHotelId()+"/details";
    }

}
