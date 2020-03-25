package rd.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rd.ecommerce.Model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
