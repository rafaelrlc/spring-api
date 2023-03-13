package io.github.rafaelrlc.vendasdata.domain.repository;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeOrId(String nome, Integer id);

    Cliente findOneByCpf(String cpf);
}
