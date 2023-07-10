package io.github.rafaelrlc.vendasdata.domain.repository;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCpfOrId(String cpf, Integer id);
    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findById(Integer id);

    @Modifying
    @Query("UPDATE Cliente c SET c.nome = :#{#cliente.nome}, c.cpf = :#{#cliente.cpf} WHERE c.id = :#{#cliente.id}")
    void updateClienteById(Cliente cliente);

    @Query(value = " SELECT Client FROM Cliente Client WHERE Client.nome = :nome ")
    List<Cliente> findByName(@Param("nome") String nome);

    @Query(" SELECT Client FROM Cliente Client LEFT JOIN FETCH Client.vendas WHERE Client.id = :id ")
    Cliente findClienteFetchVendas (@Param("id") Integer id);

}
