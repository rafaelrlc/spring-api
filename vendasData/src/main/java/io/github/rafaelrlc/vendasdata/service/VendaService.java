package io.github.rafaelrlc.vendasdata.service;

import io.github.rafaelrlc.vendasdata.domain.entity.Venda;
import io.github.rafaelrlc.vendasdata.rest.dto.VendaDTO;


public interface VendaService {
    Venda save (VendaDTO dto);
}
