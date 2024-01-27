package br.com.sistema.jfood.core.application.services;

import br.com.sistema.jfood.core.application.ports.in.produto.CriarProdutoPort;
import br.com.sistema.jfood.core.application.ports.out.ProdutoEscritaPort;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import org.springframework.stereotype.Service;

@Service
public class CriarProdutoService implements CriarProdutoPort {


    private final ProdutoEscritaPort produtoEscritaPort;

    public CriarProdutoService(ProdutoEscritaPort produtoEscritaPort) {
        this.produtoEscritaPort = produtoEscritaPort;
    }

    @Override
    public Produto criarProduto(Produto produto) {
       return this.produtoEscritaPort.cadastra(produto);
    }

    public void deletarProduto(String id) {
        this.produtoEscritaPort.deletar(id);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return this.produtoEscritaPort.atualizar(produto);
    }
}
