package bstorm.akimts.mvc.controller;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.form.HotelForm;
import bstorm.akimts.mvc.models.form.HotelUpdateForm;
import bstorm.akimts.mvc.service.HotelService;
import bstorm.akimts.mvc.service.HotelServiceImpl;
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

    private final HotelService service;

    public HotelController(@Qualifier("impl") HotelService service) {
        this.service = service;
    }

    // GET http://localhost:8080/hotel/all
    @GetMapping("/all")
    public String displayAll(Model model){
        List<HotelDTO> hotels = service.getAll();
        model.addAttribute("hotels", hotels);
        return "hotel/displayAll";
    }

    // GET http://localhost:8080/hotel/5/details
    @GetMapping("/{id}/details")
    public String displayOne(@PathVariable int id, Model model){
        model.addAttribute("hotel",service.getOne(id));
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

        long id = service.insert(form);
        return "redirect:/hotel/"+id+"/details";
    }

    // GET http://localhost:8080/hotel/{id}/update
    @GetMapping("/{id}/update")
    public String updateForm(
            @PathVariable @ModelAttribute long id,
            @ModelAttribute("hotel")HotelUpdateForm form
    ){
        HotelDTO dto = service.getOne(id);

        form.setNom(dto.getNom());
        form.setNbrEtoiles(dto.getNbrEtoiles());

        return "hotel/update";
    }

    // POST http://localhost:8080/hotel/{id}/update
    @PostMapping("/{id}/update")
    public String processUpdate(@PathVariable long id, @ModelAttribute("hotel")HotelUpdateForm form){
        service.update(id, form);
        return "redirect:/hotel/"+id+"/details";
    }
}
