package br.com.sistema.jfood.core.application.ports.in.produto;

import br.com.sistema.jfood.core.domain.produtos.Produto;

public interface CriarProdutoPort {

    Produto criarProduto(Produto produto);
    void deletarProduto(String id);

    Produto atualizarProduto(Produto produto);
}
