package bstorm.akimts.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {

    @GetMapping("/login")
    public String login(@RequestParam(required = false) boolean error){
        return "session/login";
    }


}
