package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PRODUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "nr_quantidade_estoque")
    private Integer quantidade;

    @Column(name = "vl_preco")
    private Float preco;

    @Column(name = "id_fornecedor")
    private Long fornecedor;

    @OneToMany
    @JsonBackReference
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private List<PedidoDetalhe> pedidoDetalhes;
}
