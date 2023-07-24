package io.github.rafaelrlc.vendasdata.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendaDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<VendaProdutoDTO> items;
}
