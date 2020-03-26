package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "dt_data")
    private Date data;

    @Column(name = "ds_observacao")
    private String observacao;

//    @Column(name = "id_cliente")
//    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @JsonManagedReference
    private List<PedidoDetalhe> pedidoDetalhes;
}
