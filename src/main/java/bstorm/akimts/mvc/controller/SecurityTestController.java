package bstorm.akimts.mvc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityTestController {

    @PreAuthorize("permitAll()")
    @GetMapping("/any")
    public String anyOne(){
        return "restricted/anyOne";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String isAdmin(){
        return "restricted/isAdmin";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String isUser(){
        return "restricted/isUser";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/user_admin")
    public String userOrAdmin(){
        return "restricted/isUserOrAdmin";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/anonymous")
    public String isAnonymous(){
        return "restricted/isAnonymous";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/connected")
    public String connected(){
        return "restricted/isConnected";
    }




}
