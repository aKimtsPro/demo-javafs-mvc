package bstorm.akimts.mvc.controller;

import bstorm.akimts.mvc.models.form.ClientInsertForm;
import bstorm.akimts.mvc.service.ClientService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute( "list", service.getAll() );
        return "client/list";
    }

    @GetMapping("/register")
    public String addForm(@ModelAttribute("form")ClientInsertForm form){
        return "client/add";
    }

    @PostMapping("/register")
    public String processAddForm(@Valid @ModelAttribute("form")ClientInsertForm form, BindingResult binding){
        if( binding.hasErrors() )
            return "client/add";

        service.insert(form);
        return "redirect:/client/info";
    }

    @GetMapping("/info")
    public String seeInfo(Authentication authentication, Model model){
        model.addAttribute("auth", authentication);
        return "session/user_info";
    }

}
