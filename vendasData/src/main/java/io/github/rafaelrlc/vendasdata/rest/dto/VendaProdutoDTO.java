package io.github.rafaelrlc.vendasdata.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaProdutoDTO {
    private Integer produto;
    private Integer quantidade;
}
