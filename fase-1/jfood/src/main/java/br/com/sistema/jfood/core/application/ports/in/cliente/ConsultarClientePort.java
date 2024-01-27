package br.com.sistema.jfood.core.application.ports.in.cliente;

import br.com.sistema.jfood.core.domain.cliente.Cliente;

import java.util.List;

public interface ConsultarClientePort {

    Cliente porCpf(String cpf);

    List<Cliente> listarClientes();
}
