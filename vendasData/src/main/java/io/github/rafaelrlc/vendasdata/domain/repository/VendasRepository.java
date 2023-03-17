package io.github.rafaelrlc.vendasdata.domain.repository;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.entity.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface  VendasRepository  extends  JpaRepository<Venda, Integer>{

    List<Venda> findByCliente (Cliente cliente);
}
