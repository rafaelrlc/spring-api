package io.github.rafaelrlc.vendasdata;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.repository.ClientesRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class VendasDataApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired ClientesRepository clientes, VendasRepository vendas) {
        return args -> {
            Cliente c1 = new Cliente(null,"Rafael", "23232309019");
            clientes.save(c1);
            Cliente c2 = new Cliente(null,"Pedro", "28372832911");
            clientes.save(c1);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasDataApplication.class, args);
    }
}
