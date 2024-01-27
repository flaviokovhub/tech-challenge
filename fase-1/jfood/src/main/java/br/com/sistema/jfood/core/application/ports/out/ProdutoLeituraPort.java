package br.com.sistema.jfood.core.application.ports.out;

import br.com.sistema.jfood.core.domain.produtos.Produto;

import java.util.List;

public interface ProdutoLeituraPort {
    List<Produto> buscaProdutosPorCategoria(String categoria);
}
