package br.com.sistema.jfood.core.application.services;

import br.com.sistema.jfood.adapters.out.repositories.cliente.ClienteEntity;
import br.com.sistema.jfood.adapters.out.repositories.cliente.ClienteRepository;
import br.com.sistema.jfood.core.application.exceptions.ClienteJaExisteException;
import br.com.sistema.jfood.core.application.ports.in.cliente.CadastrarClientePort;
import br.com.sistema.jfood.core.domain.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public class CadastraNovoClienteService implements CadastrarClientePort {

    private final ClienteRepository clienteRepository;

    public CadastraNovoClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrar(String cpf, String nome, String email) {

        if(this.clienteRepository.findById(cpf).isPresent()) {
            throw new ClienteJaExisteException();
        }

        return this.clienteRepository.save(new ClienteEntity(cpf, nome, email))
                .toCliente();
    }

}
