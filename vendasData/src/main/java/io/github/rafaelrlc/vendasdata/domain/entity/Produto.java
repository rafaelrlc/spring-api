package io.github.rafaelrlc.vendasdata.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto") // coloca o nome que ta no banco de dados
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") // coloca o nome que ta no banco de dados
    private Integer id;


    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_unitario", precision = 20, scale = 2)
    private BigDecimal preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
