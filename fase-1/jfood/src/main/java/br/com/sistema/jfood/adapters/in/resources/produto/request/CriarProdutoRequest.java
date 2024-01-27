package br.com.sistema.jfood.adapters.in.resources.produto.request;

import br.com.sistema.jfood.adapters.in.resources.produto.validacao.ValidaCategoria;
import br.com.sistema.jfood.core.domain.produtos.Categoria;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarProdutoRequest(
        @NotBlank
        String nome,
        @NotNull

        BigDecimal preco,
        @NotBlank
        String descricao,

        @ValidaCategoria(enumClass = Categoria.class,message = "Categoria Invalida!!")
        String categoria,
        String imagem) {

        public Produto toProduto() {
             return new Produto.Builder()
                     .comImagem(imagem)
                     .comDescricao(descricao)
                     .comPreco(preco)
                     .comNome(nome)
                     .comCategoria(categoria)
                     .build();
        }
}
