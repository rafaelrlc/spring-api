package io.github.rafaelrlc.vendasdata;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication

public class VendasDataApplication {

    private ClientesRepository clientes;

    @Autowired
    public VendasDataApplication(ClientesRepository clientes) {
        this.clientes = clientes;
    }

    @Bean
    public CommandLineRunner init(){ //
        return args -> {
            clientes.save(new Cliente("Rafael", "11223345424")); // crio o objeto cliente
            clientes.save(new Cliente("Pedro", "11223345422")); // crio o objeto cliente

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(client -> {
                client.setNome(client.getNome() + " updated");
                clientes.save(client);
            });

            todosClientes = clientes.findAll();

            //todosClientes.forEach(System.out::println);

            //System.out.println("buscando clientes \n");
            //clientes.findByNomeLike("Rafael").forEach(System.out::println);

            //System.out.println("deletando todos clientes \n");
            //todosClientes.forEach(client -> clientes.delete(client));

            //System.out.println("deletando cliente of id 2 \n");
            //clientes.deleteById(2);

            //System.out.println("todos os clientes: \n");
            //todosClientes= clientes.findAll();
            //todosClientes.forEach(System.out::println);

            //System.out.println(clientes.findById(2));
            System.out.println(clientes.findByName("Rafael updated"));
            //System.out.println(clientes.findByNomeOrId("Rafael", 1));
            //System.out.println(clientes.findOneByCpf("11223345422"));

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasDataApplication.class, args);
    }

}
