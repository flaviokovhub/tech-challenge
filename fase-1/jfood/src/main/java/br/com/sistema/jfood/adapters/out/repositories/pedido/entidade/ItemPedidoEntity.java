package br.com.sistema.jfood.adapters.out.repositories.pedido.entidade;

import br.com.sistema.jfood.core.domain.pedido.ItemPedido;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "itenspedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private String categoria;
    private String nome;
    private String descricao;
    private double valor;
    @ManyToOne(fetch = FetchType.LAZY)
    private PedidoEntity pedido;

    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(ItemPedido i,PedidoEntity pedido) {
        this.quantidade = i.quantidade();
        this.valor = i.valor();
        this.nome = i.nome();
        this.categoria = i.categoria();
        this.descricao = i.descricao();
        this.pedido = pedido;
    }

    public ItemPedido toItemPedido() {
        return new ItemPedido(
            this.nome,
            this.descricao,
            this.categoria,
            this.quantidade,
            this.valor
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoEntity that = (ItemPedidoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
