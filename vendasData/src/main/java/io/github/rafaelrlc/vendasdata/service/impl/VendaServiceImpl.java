package io.github.rafaelrlc.vendasdata.service.impl;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.entity.Venda;
import io.github.rafaelrlc.vendasdata.domain.repository.ClientesRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.ProdutosRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.VendasRepository;
import io.github.rafaelrlc.vendasdata.exception.RegraNegocioException;
import io.github.rafaelrlc.vendasdata.rest.dto.VendaDTO;
import io.github.rafaelrlc.vendasdata.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class VendaServiceImpl implements VendaService {

    private final VendasRepository repository;
    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;

    @Override
    public Venda save(VendaDTO dto) {

        Cliente cliente = clientesRepository.findById(dto.getCliente())
                .orElseThrow(() -> new RegraNegocioException("Invalid Client ID"));

        Venda venda = new Venda();
        venda.setTotal(dto.getTotal());
        venda.setDataVenda(LocalDate.now());
        venda.setCliente(cliente);

        return null;
    }
}
