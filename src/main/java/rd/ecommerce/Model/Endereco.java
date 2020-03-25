package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TB_CLIENTE_ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE_ENDERECO")
    private Long id;

    @Column(name = "DS_CEP")
    private String cep;

    @Column(name = "DS_ESTADO")
    private String estado;

    @Column(name = "DS_CIDADE")
    private String cidade;

    @Column(name = "DS_BAIRRO")
    private String bairro;

    @Column(name = "DS_RUA")
    private String rua;

    @Column(name = "DS_LUGADOURO")
    private String logradouro;

//    @Column(name = "ID_CLIENTE")
//    private Long clienteId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private Cliente cliente;
}
