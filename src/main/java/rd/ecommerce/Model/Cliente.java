package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")

public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id;

    @Column(name="ds_nome")
    @NotBlank
    private String nome;

    @Column(name="ds_telefone")
    @NotNull
    @Pattern(regexp = "[0-9]{10,11}", message = "Telefone com número inválido")
    @Size(min = 10, max= 11)
    private String telefone;

    @Column(name="ds_rg")
    @NotBlank
    @Size(min = 9, max = 13)
    private String rg;

    @Column(name="ds_cpf")
    @CPF
    private String cpf;
    @Column(name="ds_email")

    @NotNull
    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    @NotEmpty
    private List<Endereco> enderecos;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario user;
}
