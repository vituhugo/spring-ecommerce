package rd.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Column(name="DS_NOME")
    @NotBlank
    private String nome;

    @Column(name="DS_TELEFONE")
    @NotNull
    @Pattern(regexp = "[0-9]{10,11}", message = "Telefone com número inválido")
    @Size(min = 10, max= 11)
    private String telefone;

    @Column(name="DS_RG")
    @NotBlank
    @Size(min = 9, max = 13)
    private String rg;

    @Column(name="DS_CPF")
    @CPF
    private String cpf;
    @Column(name="DS_EMAIL")

    @NotNull
    @Email
    @UniqueElements
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @NotEmpty
    private List<Endereco> enderecos;
}
