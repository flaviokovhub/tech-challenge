package br.com.sistema.jfood.adapters.in.resources.pedido;

import br.com.sistema.jfood.core.application.ports.in.pedido.ProcessaPedidoPort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoResource {

    private final ProcessaPedidoPort processaPedidoPort;

    public PedidoResource(ProcessaPedidoPort processaPedidoPort) {
        this.processaPedidoPort = processaPedidoPort;
    }

    @GetMapping
    @Transactional(readOnly = true)
    ResponseEntity<?> listarPedidos() {
       return ResponseEntity.ok(this.processaPedidoPort.listarPedidos());
    }
}
