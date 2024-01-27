package br.com.sistema.jfood.adapters.in.resources.produto.request;

import br.com.sistema.jfood.adapters.in.resources.produto.validacao.ValidaCategoria;
import br.com.sistema.jfood.core.domain.produtos.Categoria;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record AtualizarProdutoRequest (
        @NotBlank
        String nome,
        @NotNull

        BigDecimal preco,
        @NotBlank
        String descricao,

        @ValidaCategoria(enumClass = Categoria.class,message = "Categoria Invalida!!")
        String categoria,
        String imagem) {

    public Produto toProdutoCom(UUID id) {
        return new Produto.Builder()
                .comId(id)
                .comImagem(imagem)
                .comDescricao(descricao)
                .comPreco(preco)
                .comNome(nome)
                .comCategoria(categoria)
                .build();
    }

}
