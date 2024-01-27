package br.com.sistema.jfood.core.application.services;

import br.com.sistema.jfood.adapters.out.repositories.cliente.ClienteEntity;
import br.com.sistema.jfood.adapters.out.repositories.cliente.ClienteRepository;
import br.com.sistema.jfood.core.application.exceptions.ClienteNaoIdentificadoException;
import br.com.sistema.jfood.core.application.ports.in.cliente.ConsultarClientePort;
import br.com.sistema.jfood.core.domain.cliente.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConsultarClienteService implements ConsultarClientePort {

    private final ClienteRepository clienteRepository;

    public ConsultarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente porCpf(String cpf) {
        return this.clienteRepository.findById(cpf).orElseThrow(() -> new ClienteNaoIdentificadoException(cpf))
                .toCliente();
    }

    @Override
    public List<Cliente> listarClientes() {
        return this.clienteRepository.findAll()
                .stream()
                .map(ClienteEntity::toCliente)
                .collect(Collectors.toList());
    }


}
