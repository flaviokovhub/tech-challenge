package br.com.sistema.jfood.adapters.out.repositories.produto.exception;

public class CadastrarProdutoException extends RuntimeException {

    public CadastrarProdutoException(String message) {
        super(String.format("Erro ao tentar cadastrar o produto: %s",message));
    }
}
