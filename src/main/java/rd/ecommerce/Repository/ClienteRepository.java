package rd.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rd.ecommerce.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
