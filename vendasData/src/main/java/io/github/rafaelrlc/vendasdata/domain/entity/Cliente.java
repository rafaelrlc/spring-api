package io.github.rafaelrlc.vendasdata.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cliente") // coloca o nome que ta no banco de dados
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") // coloca o nome que ta no banco de dados
    private Integer id;


    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 100)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente" , fetch = FetchType.LAZY) // aqui ficaram as vendas no qual a Tabela pedidos se relaciona com tal cliente
    private Set<Venda> vendas;


    public Cliente(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
