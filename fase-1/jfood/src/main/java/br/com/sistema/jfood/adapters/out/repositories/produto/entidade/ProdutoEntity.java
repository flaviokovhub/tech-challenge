package br.com.sistema.jfood.adapters.out.repositories.produto.entidade;

import br.com.sistema.jfood.core.domain.produtos.Categoria;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid", updatable = false,name = "id")
    private UUID id;

    private String nome;
    private BigDecimal preco;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "imagem_url")
    private String imagem;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        if(Objects.nonNull(produto.getId())) {
            this.id = produto.getId();
        }
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.imagem = produto.getImagem();
    }

    public ProdutoEntity(String id) {
        this.id = UUID.fromString(id);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoEntity that = (ProdutoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public Produto toProduto() {
        return new Produto.Builder()
                .comId(id)
                .comImagem(imagem)
                .comDescricao(descricao)
                .comPreco(preco)
                .comNome(nome)
                .comCategoria(categoria.name())
                .build();
    }
}
