package rd.ecommerce.Controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.hibernate.mapping.Map;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rd.ecommerce.Model.Cliente;
import rd.ecommerce.Model.Usuario;
import rd.ecommerce.Repository.ClienteRepository;
import rd.ecommerce.Repository.EnderecoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import rd.ecommerce.Repository.UsuarioRepository;

import javax.persistence.EntityNotFoundException;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = repository.findAll();
        return ResponseEntity.status(200).body(clientes);
    }

    @GetMapping("/clientes/search")
    public ResponseEntity<List<Cliente>> search(
            @PathParam("nome") String nome,
            @PathParam("email") String email,
            @PathParam("cpf") String cpf
    ){

        String stringQuery = "SELECT c FROM Cliente c WHERE 1 = 1";

        if (nome != null && !nome.equals("")) {
            stringQuery += " AND c.nome LIKE concat('%', :nome, '%')";
        }

        if (email != null && !email.equals("")) {
            stringQuery += " AND c.email LIKE concat('%', :email, '%')";
        }

        if (cpf != null && !cpf.equals("")) {
            stringQuery += " AND c.cpf LIKE concat('%', :cpf, '%')";
        }

        Query query = em.createQuery(stringQuery, Cliente.class);

        if (nome != null && !nome.equals("")) {
            query.setParameter("nome", nome);
        }

        if (email != null && !email.equals("")) {
            query.setParameter("email", email);
        }

        if (cpf != null && !cpf.equals("")) {
            query.setParameter("cpf", cpf);
        }

        return ResponseEntity.ok().body(query.getResultList());
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> criar(@Valid @RequestBody Cliente cliente) {

        if (cliente == null) {
            return ResponseEntity.status(400).body("Cliente não pode estar vazio");
        }

        Cliente clienteAtualizado = repository.save(cliente);
        return ResponseEntity.status(201).body(clienteAtualizado);
//        return new ResponseEntity<>(clienteAtualizado, HttpStatus.CREATED);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Cliente> opt_cliente = repository.findById(id);
        Cliente cliente = opt_cliente.orElse(null);
        if (cliente == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(cliente);
    }

//    @PutMapping("/clientes/{id}")
//    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
////        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "ADSADDSAD");
//
//        Cliente cliente1 = repository.getOne(id);
//
//        cliente1.setNome(cliente.getNome());
//        cliente1.setCpf(cliente.getCpf());
//        cliente1.setEmail(cliente.getEmail());
//        cliente1.setRg(cliente.getRg());
//        cliente1.setTelefone(cliente.getTelefone());
//        Cliente response = repository.save(cliente1);
//
//        return ResponseEntity.status(200).body(response);
//    }

//    @PatchMapping("/clientes/{id}")
//    public ResponseEntity<?> modificarParcial(@PathVariable("id") Long id, @RequestBody Cliente clienteDetails) {
//
//        if (clienteDetails == null) {
//            return ResponseEntity.status(400).body("O cliente não pode ser vazio!");
//        }
//
////        Cliente cliente = repository.findById(id).orElse(null);
////
////        if (cliente == null) {
////            return ResponseEntity.status(404).body("O cliente não foi encontrado!");
////        }
//        Cliente cliente = repository
//                .findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
//
//
//        if (clienteDetails.getNome() != null) {
//            cliente.setNome(clienteDetails.getNome());
//        }
//
//        if (clienteDetails.getCpf() != null) {
//            cliente.setCpf(clienteDetails.getCpf());
//        }
//
//        if (clienteDetails.getEmail() != null) {
//            cliente.setEmail(clienteDetails.getEmail());
//        }
//
//        Cliente response = repository.save(cliente);
//
//        return ResponseEntity.status(200).body(response);
//    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    //            repository.deleteById(id);
                    return ResponseEntity.status(204).body("Cliente excluido");

                }).orElse(ResponseEntity.status(404).build());
    }
//    EntityNotFoundException
//    @ExceptionHandler(EntityNotFoundException.class)
//    public String handlerEntityNotFoundException(EntityNotFoundException ex) {
//        return "Capturei o erro da Entidade!";
//    }
//
//    @ExceptionHandler(Exception.class)
//    public String handlerBatataException(Exception ex) {
//        return "Agora capture a Exception!";
//    }
}
