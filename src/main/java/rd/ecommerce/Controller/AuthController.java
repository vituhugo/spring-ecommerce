package rd.ecommerce.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/validar-credenciais")
    public Authentication validate(Authentication user) {
        return user;
    }
}
