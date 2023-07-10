package io.github.rafaelrlc.vendasdata.service.impl;

import io.github.rafaelrlc.vendasdata.domain.repository.VendasRepository;
import io.github.rafaelrlc.vendasdata.service.VendaService;
import org.springframework.stereotype.Service;


@Service
public class VendaServiceImpl implements VendaService {

    private final VendasRepository repository;

    public VendaServiceImpl(VendasRepository repository) {
        this.repository = repository;
    }
}
