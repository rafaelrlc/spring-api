package io.github.rafaelrlc.vendasdata.domain.repository;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeOrId(String nome, Integer id);
    Cliente findOneByCpf(String cpf);

    @Query(value = " SELECT Client FROM Cliente Client WHERE Client.nome = :nome ")
    List<Cliente> findByName(@Param("nome") String nome);

    @Query(" SELECT Client FROM Cliente Client LEFT JOIN FETCH Client.vendas WHERE Client.id = :id ")
    Cliente findClienteFetchVendas (@Param("id") Integer id);

}
