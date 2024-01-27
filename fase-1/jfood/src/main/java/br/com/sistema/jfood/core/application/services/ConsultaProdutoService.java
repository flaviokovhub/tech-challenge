package br.com.sistema.jfood.core.application.services;

import br.com.sistema.jfood.core.application.ports.in.produto.ConsultaProdutoPort;
import br.com.sistema.jfood.core.application.ports.out.ProdutoLeituraPort;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaProdutoService implements ConsultaProdutoPort {

    private final ProdutoLeituraPort produtoLeituraPort;

    public ConsultaProdutoService(ProdutoLeituraPort produtoLeituraPort) {
        this.produtoLeituraPort = produtoLeituraPort;
    }

    @Override
    public List<Produto> buscaProdutosPorCategoria(String categoria) {
         return produtoLeituraPort.buscaProdutosPorCategoria(categoria);
    }
}
