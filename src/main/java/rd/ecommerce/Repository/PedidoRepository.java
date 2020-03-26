package rd.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rd.ecommerce.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
