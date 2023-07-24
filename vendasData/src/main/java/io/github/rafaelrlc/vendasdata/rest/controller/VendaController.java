package io.github.rafaelrlc.vendasdata.rest.controller;


import io.github.rafaelrlc.vendasdata.domain.entity.Venda;
import io.github.rafaelrlc.vendasdata.rest.dto.VendaDTO;
import io.github.rafaelrlc.vendasdata.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    private VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody VendaDTO dto) {
        Venda venda = service.save(dto);
        return venda.getId();
    }

}
