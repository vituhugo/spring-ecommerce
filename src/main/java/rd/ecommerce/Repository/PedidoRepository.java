package rd.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rd.ecommerce.Model.Pedido;
import rd.ecommerce.Model.Produto;

import java.awt.print.Pageable;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
