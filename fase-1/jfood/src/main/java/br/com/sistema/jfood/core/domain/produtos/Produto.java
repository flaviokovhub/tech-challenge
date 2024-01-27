package br.com.sistema.jfood.core.domain.produtos;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private final UUID id;
    private final String nome;
    private final BigDecimal preco;
    private final String descricao;
    private final Categoria categoria;
    private final String imagem;

    private Produto(Builder builder) {
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.descricao = builder.descricao;
        this.categoria = builder.categoria;
        this.imagem = builder.imagem;
        this.id = builder.id;
    }

    public static class Builder {
        private String nome;
        private BigDecimal preco;
        private String descricao;
        private Categoria categoria;
        private String imagem;
        private UUID id;

        public Builder comId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comPreco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder comDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder comCategoria(String categoria) {
            this.categoria = Categoria.valueOf(categoria);
            return this;
        }

        public Builder comImagem(String imagem) {
            this.imagem = imagem;
            return this;
        }
        public Produto build(){
            return new Produto(this);
        }
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

    public UUID getId() {
        return id;
    }
}
