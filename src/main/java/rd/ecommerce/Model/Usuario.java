package rd.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_usuario")
    private Long id;

    @Column(name="ds_nome")
    private String nome;

    @Column(name="ds_email")
    private String email;

    @Column(name="ds_senha")
    private String senha;

    @Column(name="ds_nivel_acesso")
    private String nivelAcesso;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Cliente cliente;
}
