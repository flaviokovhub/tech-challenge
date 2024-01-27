package br.com.sistema.jfood.adapters.out.repositories.produto;

import br.com.sistema.jfood.adapters.out.repositories.produto.entidade.ProdutoEntity;
import br.com.sistema.jfood.core.application.ports.out.ProdutoLeituraPort;
import br.com.sistema.jfood.core.domain.produtos.Categoria;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
 class ProdutoLeituraRepositorio implements ProdutoLeituraPort {

    private static final Logger LOG = Logger.getLogger(ProdutoLeituraRepositorio.class.getName());
    private final ProdutoRepository produtoRepository;

    public ProdutoLeituraRepositorio(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> buscaProdutosPorCategoria(String categoria) {
        return this.produtoRepository.findAllByCategoria(Categoria.valueOf(categoria))
                .stream()
                .map(ProdutoEntity::toProduto)
                .collect(Collectors.toList());
    }
}
