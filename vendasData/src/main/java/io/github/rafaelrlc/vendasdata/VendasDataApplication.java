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
            clientes.saveClient(new Cliente("Rafael")); // crio o objeto cliente
            clientes.saveClient(new Cliente("Pedro")); // crio o objeto cliente

            List<Cliente> todosClientes = clientes.getAll();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(client -> {
                client.setNome(client.getNome() + " updated");
                clientes.updateClient(client);
            });

            //System.out.println("buscando clientes \n");
            //clientes.searchByName("Rafael").forEach(System.out::println);

            //System.out.println("deletando todos clientes \n");
            //todosClientes.forEach(client -> clientes.deleteClient(client));

            //System.out.println("deletando cliente of id 2 \n");
            //clientes.deleteById(2);

            System.out.println("todos os clientes: \n");
            todosClientes= clientes.getAll();
            todosClientes.forEach(System.out::println);



            //System.out.println(clientes.searchByName("Rafael"));

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasDataApplication.class, args);
    }

}
