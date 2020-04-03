package rd.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rd.ecommerce.Model.Usuario;
import rd.ecommerce.Repository.UsuarioRepository;

@RestController
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/perfil")
    public Usuario perfil(Authentication authentication) {
        return usuarioRepository.findByEmail(authentication.getName());
    }
}
