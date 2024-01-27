package br.com.sistema.jfood.adapters.in.resources.cliente.mapper;

import br.com.sistema.jfood.adapters.in.resources.cliente.response.ClienteResponse;
import br.com.sistema.jfood.core.domain.cliente.Cliente;

public class ClienteMapper {

    public static ClienteResponse paraClienteResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }
}
