package br.com.sistema.jfood.core.application.ports.out;

import br.com.sistema.jfood.core.domain.produtos.Produto;

public interface ProdutoEscritaPort {
    Produto cadastra(Produto produto);

    void deletar(String id);

    Produto atualizar(Produto produto);
}
