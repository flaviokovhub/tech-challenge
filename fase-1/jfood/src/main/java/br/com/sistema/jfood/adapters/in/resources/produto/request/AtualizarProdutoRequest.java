package br.com.sistema.jfood.adapters.in.resources.produto.request;

import br.com.sistema.jfood.core.domain.produtos.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record AtualizarProdutoRequest (
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

    public Produto toProdutoCom(UUID id) {
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
