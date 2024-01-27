package br.com.sistema.jfood.core.application.ports.in.produto;

import br.com.sistema.jfood.core.domain.produtos.Produto;

import java.util.List;

public interface ConsultaProdutoPort {
    List<Produto> buscaProdutosPorCategoria(String categoria);
}
