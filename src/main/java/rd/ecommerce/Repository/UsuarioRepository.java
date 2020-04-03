package rd.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rd.ecommerce.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
}
