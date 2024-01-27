package br.com.sistema.jfood.adapters.in.resources.produto.request;

import br.com.sistema.jfood.core.domain.produtos.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarProdutoRequest(
        @NotBlank
        String nome,
        @NotNull

        @DecimalMin(value = "0", inclusive = false)
        BigDecimal preco,
        @NotBlank
        String descricao,
        CategoriaRequest categoria,
        @NotBlank
        String imagem) {

        public Produto toProduto() {
             return new Produto.Builder()
                     .comImagem(imagem)
                     .comDescricao(descricao)
                     .comPreco(preco)
                     .comNome(nome)
                     .comCategoria(categoria.name())
                     .build();
        }
}
