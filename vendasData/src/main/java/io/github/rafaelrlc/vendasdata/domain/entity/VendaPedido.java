package io.github.rafaelrlc.vendasdata.domain.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "venda_pedido")
public class VendaPedido {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda pedido) {
        this.venda = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
