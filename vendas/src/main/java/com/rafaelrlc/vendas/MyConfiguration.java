package com.rafaelrlc.vendas;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@Development // será herdado as config do Development.java
public class MyConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO CONFIG DE DESENVOLVIMENTO");
        };
    }

}
