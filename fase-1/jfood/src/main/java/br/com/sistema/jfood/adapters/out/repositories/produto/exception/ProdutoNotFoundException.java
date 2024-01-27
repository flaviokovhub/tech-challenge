package br.com.sistema.jfood.adapters.out.repositories.produto.exception;

import java.util.UUID;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(UUID id) {
        super(String.format("Produto %s não existe para ser atualizado",id.toString()));
    }
}
