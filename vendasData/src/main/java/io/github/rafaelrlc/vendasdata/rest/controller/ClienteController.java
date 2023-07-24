package io.github.rafaelrlc.vendasdata.rest.controller;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.repository.ClientesRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClientesRepository clientesRepository;

    public ClienteController( ClientesRepository clientesRepository ) {
        this.clientesRepository = clientesRepository;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create( @RequestBody Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Cliente novoCliente) {
        Cliente clienteExistente = clientesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found"));

        novoCliente.setId(clienteExistente.getId());
        clientesRepository.save(novoCliente);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Integer id) {
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if(cliente.isPresent()) clientesRepository.delete(cliente.get());

        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not Found");

    }

    @GetMapping("/{id}")
    public Cliente getClienteById( @PathVariable Integer id ){
        return clientesRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found"));
    }

    @GetMapping("cpf/{cpf}")
    public Cliente getClienteByCpf( @PathVariable String cpf) {
        return clientesRepository.findByCpf(cpf).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not Found"));
    }

//    @GetMapping
//    public List<Cliente> find( @RequestBody Cliente filtro ){
//        System.out.println(filtro);
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(
//                        ExampleMatcher.StringMatcher.CONTAINING );
//
//        Example<Cliente> example = Example.of(filtro, matcher);
//        System.out.println(example);
//        return clientesRepository.findAll(example);
//    }

    @GetMapping
    public List<Cliente> getAll () {
        return clientesRepository.findAll();
    }

}