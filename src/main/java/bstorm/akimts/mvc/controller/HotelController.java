package bstorm.akimts.mvc.controller;

import bstorm.akimts.mvc.models.dto.HotelDTO;
import bstorm.akimts.mvc.service.HotelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private final HotelServiceImpl service;

    public HotelController(HotelServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String displayAll(Model model){
        List<HotelDTO> hotels = service.getAll();
        model.addAttribute("hotels", hotels);
        return "hotel/displayAll";
    }

    // GET http://localhost:8080/hotel/5/details
    @GetMapping("{id}/details")
    public String displayOne(@PathVariable int id){
        // TODO: recuperer et ajouter attribut hotel
        return "hotel/displayOne";
    }

}
