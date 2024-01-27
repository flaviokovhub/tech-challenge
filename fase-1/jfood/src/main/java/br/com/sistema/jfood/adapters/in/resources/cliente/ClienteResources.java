package br.com.sistema.jfood.adapters.in.resources.cliente;

import br.com.sistema.jfood.adapters.in.resources.cliente.mapper.ClienteMapper;
import br.com.sistema.jfood.adapters.in.resources.cliente.request.CadastraClienteRequest;
import br.com.sistema.jfood.adapters.in.resources.cliente.response.ClienteResponse;
import br.com.sistema.jfood.core.application.ports.in.cliente.CadastrarClientePort;
import br.com.sistema.jfood.core.application.ports.in.cliente.ConsultarClientePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResources {

    private final ConsultarClientePort consultarClientePort;

    private final CadastrarClientePort cadastrarClientePort;

    public ClienteResources(ConsultarClientePort consultarClientePort, CadastrarClientePort cadastrarClientePort) {
        this.consultarClientePort = consultarClientePort;
        this.cadastrarClientePort = cadastrarClientePort;
    }

    @Transactional(readOnly = true)
    @GetMapping("/{cpf}")
    ResponseEntity<ClienteResponse> indentificarCliente(@PathVariable(value = "cpf") String cpf) {

        var cliente = this.consultarClientePort.porCpf(cpf);

        return ResponseEntity.ok(ClienteMapper.paraClienteResponse(cliente));
    }

    @Transactional(readOnly = true)
    @GetMapping
    ResponseEntity<List<ClienteResponse>> listarClientes() {

        var clientes = this.consultarClientePort.listarClientes()
                .stream()
                .map(ClienteMapper::paraClienteResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(clientes);
    }

    @Transactional
    @PostMapping
    ResponseEntity<?> cadastrarCliente(@RequestBody @Valid CadastraClienteRequest request) {

        var cliente = this.cadastrarClientePort.cadastrar(request.cpf(), request.nome(), request.email());

        return ResponseEntity.created(URI.create("")).body(cliente);

    }
}
