package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CLIENTE")

public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CLIENTE")
    private Long id;

    @NotNull(message = "Não pode cara!")
    @Column(name="DS_NOME")
    private String nome;
    @Column(name="DS_TELEFONE")
    private String telefone;
    @Column(name="DS_RG")
    private String rg;
    @Column(name="DS_CPF")
    private String cpf;
    @Column(name="DS_EMAIL")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private List<Endereco> enderecos;
}
