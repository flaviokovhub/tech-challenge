package br.com.sistema.jfood.adapters.in.resources.produto.response;

import br.com.sistema.jfood.core.domain.produtos.Produto;

import java.math.BigDecimal;

public record ProdutoAtualizadoResponse(
        String id,
        String nome,
        BigDecimal preco,
        String descricao,
        String categoria) {

    public static ProdutoAtualizadoResponse mapper(Produto p) {
        return new ProdutoAtualizadoResponse(p.getId().toString(), p.getNome(), p.getPreco(), p.getDescricao(), p.getCategoria().name());
    }
}
