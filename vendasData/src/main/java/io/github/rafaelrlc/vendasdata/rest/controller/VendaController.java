package io.github.rafaelrlc.vendasdata.rest.controller;


import io.github.rafaelrlc.vendasdata.service.VendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    private VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

}
