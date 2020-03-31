package rd.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rd.ecommerce.Model.Pedido;
import rd.ecommerce.Repository.PedidoRepository;

import java.util.List;

@RestController
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedidos")
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // Vou /pedidos com método POST com os dados produto_id: 1, quantidade: 10,
    // ele me retorna um objeto PEDIDO {id: ?, produto_id: 1, quantidade: 10}
    // Validação no banco de dados.

    
}
