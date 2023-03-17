package io.github.rafaelrlc.vendasdata;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.entity.Venda;
import io.github.rafaelrlc.vendasdata.domain.repository.ClientesRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication

public class VendasDataApplication {

    private ClientesRepository clientes;
    private VendasRepository vendas;

    @Autowired
    public VendasDataApplication(ClientesRepository clientes, VendasRepository vendas) {
        this.clientes = clientes;
        this.vendas = vendas;
    }

    @Bean
    public CommandLineRunner init(){ //
        return args -> {
            clientes.save(new Cliente("Rafael", "11223345424")); // crio o objeto cliente
            Cliente fulano = new Cliente("Fulano", "11223345422");
            clientes.save(fulano); // crio o objeto cliente

            Venda venda1 = new Venda();
            venda1.setCliente(fulano);
            venda1.setDataVenda(LocalDate.now());
            venda1.setTotal(BigDecimal.valueOf(100));

            vendas.save(venda1);

            Venda venda2 = new Venda();
            venda2.setCliente(fulano);
            venda2.setDataVenda(LocalDate.now());
            venda2.setTotal(BigDecimal.valueOf(200));

            vendas.save(venda2);

            System.out.println(clientes.findClienteFetchVendas(fulano.getId()).getVendas());
            System.out.println(vendas.findByCliente(fulano));


            List<Cliente> todosClientes = clientes.findAll();
            //todosClientes.forEach(System.out::println);

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
            //System.out.println(clientes.findByName("Rafael updated"));
            //System.out.println(clientes.findByNomeOrId("Rafael", 1));
            //System.out.println(clientes.findOneByCpf("11223345422"));

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasDataApplication.class, args);
    }

}
