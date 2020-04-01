package rd.ecommerce.Repository;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import rd.ecommerce.Model.Cliente;
import rd.ecommerce.Model.Endereco;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void adicionarNovoRegistro() {

        List<Endereco> enderecos = Arrays.asList(
                new Endereco(null, "04457090", "SP", "São Paulo", "Jardim Palmares", "Rua marino pinto", "135", null)
        );

        Cliente cliente = new Cliente();
        cliente.setTelefone("1121551421");
        cliente.setEmail("victor@teste.com");
        cliente.setCpf("37790715844");
        cliente.setRg("492837776");
        cliente.setNome("Victor");
        cliente.setEnderecos(enderecos);

        Cliente clientePersitido = clienteRepository.save(cliente);

        Assertions.assertThat(clientePersitido.getId()).isNotNull();
        Assertions.assertThat(clientePersitido.getTelefone()).isEqualTo(cliente.getTelefone());
        Assertions.assertThat(clientePersitido.getEmail()).isEqualTo(cliente.getEmail());
        Assertions.assertThat(clientePersitido.getCpf()).isEqualTo(cliente.getCpf());
        Assertions.assertThat(clientePersitido.getRg()).isEqualTo(cliente.getRg());
        Assertions.assertThat(clientePersitido.getNome()).isEqualTo(cliente.getNome());
    }

    @Test
    public void adicionarNovoRegistroSemNomeDeveDispararValidationErro() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("não pode estar em branco");
        List<Endereco> enderecos = Arrays.asList(
                new Endereco(null, "04457090", "SP", "São Paulo", "Jardim Palmares", "Rua marino pinto", "135", null)
        );

        Cliente cliente = new Cliente();
        cliente.setTelefone("1121551421");
        cliente.setEmail("victor@teste.com");
        cliente.setCpf("37790715844");
        cliente.setRg("492837776");
        cliente.setEnderecos(enderecos);

        Cliente clientePersitido = clienteRepository.save(cliente);

        //TODO FAZER NA PROXIMA AULA
    }

    @Test
    public void excluirRegistro() {

        List<Endereco> enderecos = Arrays.asList(
                new Endereco(null, "04457090", "SP", "São Paulo", "Jardim Palmares", "Rua marino pinto", "135", null)
        );

        Cliente cliente = new Cliente();
        cliente.setNome("Victor");
        cliente.setTelefone("1121551421");
        cliente.setEmail("victor@teste.com");
        cliente.setCpf("37790715844");
        cliente.setRg("492837776");
        cliente.setEnderecos(enderecos);

        Cliente clientePersitido = clienteRepository.save(cliente);

        clienteRepository.delete(clientePersitido);
    }

    @Test
    public void atualizarRegistro() {
        List<Endereco> enderecos = Arrays.asList(
                new Endereco(null, "04457090", "SP", "São Paulo", "Jardim Palmares", "Rua marino pinto", "135", null)
        );

        Cliente cliente = new Cliente();
        cliente.setNome("Victor");
        cliente.setTelefone("1121551421");
        cliente.setEmail("victor@teste.com");
        cliente.setCpf("37790715844");
        cliente.setRg("492837776");
        cliente.setEnderecos(enderecos);

        clienteRepository.save(cliente);

        cliente.setNome("Victor Segundo");
        Cliente clienteAtualizado = clienteRepository.save(cliente);

        Assertions.assertThat(clienteAtualizado.getId()).isEqualTo(cliente.getId());
        Assertions.assertThat(clienteAtualizado.getTelefone()).isEqualTo(cliente.getTelefone());
        Assertions.assertThat(clienteAtualizado.getEmail()).isEqualTo(cliente.getEmail());
        Assertions.assertThat(clienteAtualizado.getCpf()).isEqualTo(cliente.getCpf());
        Assertions.assertThat(clienteAtualizado.getRg()).isEqualTo(cliente.getRg());
        Assertions.assertThat(clienteAtualizado.getNome()).isEqualTo(cliente.getNome());
    }
}
