package br.com.sistema.jfood.adapters.in.resources.produto.response;

import br.com.sistema.jfood.core.domain.produtos.Produto;

import java.math.BigDecimal;

public record ListarProdutosResponse(
        String id,
        String nome,
        BigDecimal preco,
        String descricao,
        String categoria) {

    public static ListarProdutosResponse mapper(Produto p) {
        return new ListarProdutosResponse(p.getId().toString(), p.getNome(), p.getPreco(), p.getDescricao(), p.getCategoria().name());
    }
}
