package br.com.sistema.jfood.adapters.out.repositories.produto.exception;

import java.util.UUID;

public class AtualizarProdutoException extends RuntimeException {
    public AtualizarProdutoException(UUID id) {
        super(String.format("Erro ao tentar atualizar o produto: %s",id.toString()));
    }
}
