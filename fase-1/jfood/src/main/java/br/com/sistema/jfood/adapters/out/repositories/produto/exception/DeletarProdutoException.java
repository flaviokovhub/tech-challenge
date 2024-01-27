package br.com.sistema.jfood.adapters.out.repositories.produto.exception;

public class DeletarProdutoException extends RuntimeException {
    public DeletarProdutoException(String id) {
        super(String.format("Erro ao tentar deletar o produto com id: %s",id));
    }
}
