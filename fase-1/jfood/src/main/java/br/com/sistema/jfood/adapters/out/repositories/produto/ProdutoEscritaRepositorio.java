package br.com.sistema.jfood.adapters.out.repositories.produto;

import br.com.sistema.jfood.adapters.out.repositories.produto.entidade.ProdutoEntity;
import br.com.sistema.jfood.adapters.out.repositories.produto.exception.AtualizarProdutoException;
import br.com.sistema.jfood.adapters.out.repositories.produto.exception.CadastrarProdutoException;
import br.com.sistema.jfood.adapters.out.repositories.produto.exception.DeletarProdutoException;
import br.com.sistema.jfood.core.application.ports.out.ProdutoEscritaPort;
import br.com.sistema.jfood.core.domain.produtos.Produto;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
 class ProdutoEscritaRepositorio implements ProdutoEscritaPort {

    private static final Logger LOG = Logger.getLogger(ProdutoEscritaRepositorio.class.getName());
    private final ProdutoRepository produtoRepository;

    public ProdutoEscritaRepositorio(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Override
    public Produto cadastra(Produto produto) {
        try {
            return this.produtoRepository.save(new ProdutoEntity(produto)).toProduto();
        }catch (Exception e) {
            LOG.log(Level.SEVERE,e.getMessage());
            throw new CadastrarProdutoException(produto.getNome());
        }
    }

    @Override
    public void deletar(String id) {
        try {
            this.produtoRepository.deleteById(UUID.fromString(id));
        }catch (Exception e) {
            LOG.log(Level.SEVERE,e.getMessage());
            throw new DeletarProdutoException(id);
        }
    }

    @Override
    public Produto atualizar(Produto produto) {
        try {
            return this.produtoRepository.save(new ProdutoEntity(produto)).toProduto();
        }catch (Exception e) {
            LOG.log(Level.SEVERE,e.getMessage());
            throw new AtualizarProdutoException(produto.getId());
        }
    }
}
