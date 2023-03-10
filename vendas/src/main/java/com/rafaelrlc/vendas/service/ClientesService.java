package com.rafaelrlc.vendas.service;
import com.rafaelrlc.vendas.model.Cliente;
import com.rafaelrlc.vendas.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository; // uma declaração de variável usada para injetar

    @Autowired
    public ClientesService( ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
