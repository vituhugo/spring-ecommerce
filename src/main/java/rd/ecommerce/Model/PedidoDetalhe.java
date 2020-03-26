package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_pedido_detalhe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetalhe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_detalhe")
    private Long id;

    @Column(name = "vl_preco")
    private Float preco;

    @Column(name = "nr_quantidade")
    private Integer quantidade;

    @Column(name = "pc_desconto")
    private Float desconto;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @JsonManagedReference
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @JsonBackReference
    private Pedido pedido;
}
