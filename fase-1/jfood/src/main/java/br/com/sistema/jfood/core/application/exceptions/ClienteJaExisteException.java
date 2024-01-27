package br.com.sistema.jfood.core.application.exceptions;

public class ClienteJaExisteException extends RuntimeException {

    public ClienteJaExisteException() {
        super("Esse cliente já existe");
    }
}
