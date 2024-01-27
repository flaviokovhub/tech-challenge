package br.com.sistema.jfood.core.application.exceptions;

public class ClienteNaoIdentificadoException extends RuntimeException {
    public ClienteNaoIdentificadoException(String message) {
        super(String.format("Não foi possivel identificar o cliente para esse cpf: %s", message));
    }
}
