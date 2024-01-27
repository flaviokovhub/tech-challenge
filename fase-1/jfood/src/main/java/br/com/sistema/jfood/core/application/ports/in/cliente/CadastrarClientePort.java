package br.com.sistema.jfood.core.application.ports.in.cliente;

import br.com.sistema.jfood.core.domain.cliente.Cliente;

public interface CadastrarClientePort {

    Cliente cadastrar(String cpf,String nome,String email);
}
