package bstorm.akimts.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("msg", "Bien le bonjour");
        return "hello";
    }

    @GetMapping("/world")
    public String world(){
        // rajoute du model
        return "world";
    }

}
