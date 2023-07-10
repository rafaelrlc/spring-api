package io.github.rafaelrlc.vendasdata.rest.controller;


import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.entity.Produto;
import io.github.rafaelrlc.vendasdata.domain.repository.ProdutosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController( ProdutosRepository produtos ) {
        this.produtosRepository = produtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto) {
        return produtosRepository.save(produto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Produto newProduto, @PathVariable Integer id) {
        Produto produtoFounded = produtosRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not Found"));
        newProduto.setId(produtoFounded.getId());
        produtosRepository.save(newProduto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id) {
        Produto produtoFounded = produtosRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not Found"));
        produtosRepository.delete(produtoFounded);
    }

    @GetMapping("/{id}")
    public Produto getById (@PathVariable Integer id) {
        return produtosRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not Found"));
    }

    @GetMapping
    public List<Produto> find(Produto filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return produtosRepository.findAll(example);
    }

}
