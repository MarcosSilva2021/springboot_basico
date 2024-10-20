package dio.spring_security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping
    public String welcome(){
        return "Bem vindo ao site do Spring Boot Web API";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('MANAGERS','USERS')")
    public String users(){
        return "Usuários autorizados ...";
    }    
    
    @GetMapping("/managers")
    @PreAuthorize("hasRole('MANAGERS')")
    public String managers(){
        return "Admins autorizados ...";
    }
}
