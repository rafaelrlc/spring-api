package io.github.rafaelrlc.vendasdata.domain.repository;

import io.github.rafaelrlc.vendasdata.domain.entity.VendaPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface  VendaPedidosRepository  extends  JpaRepository<VendaPedido, Integer>{


}
