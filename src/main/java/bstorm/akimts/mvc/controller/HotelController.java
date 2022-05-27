package bstorm.akimts.mvc.controller;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.models.form.HotelForm;
import bstorm.akimts.mvc.service.HotelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private final HotelServiceImpl service;

    public HotelController(HotelServiceImpl service) {
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
    public String processCreate( @ModelAttribute("hotel") HotelForm form ){

        if( false /* est invalide */)
            ;// faire un truc

        long id = service.insert(form);
        return "redirect:/hotel/"+id+"/details";
    }
}
