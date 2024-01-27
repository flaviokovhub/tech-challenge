package br.com.sistema.jfood.adapters.in.resources.checkout;

import br.com.sistema.jfood.adapters.in.resources.pedido.request.RecebePedidoRequest;
import br.com.sistema.jfood.adapters.in.resources.checkout.response.CheckoutResponse;
import br.com.sistema.jfood.core.application.ports.in.pedido.ProcessaPedidoPort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/checkout/pedidos")
public class CheckoutResource {


    private final ProcessaPedidoPort processaPedidoPort;

    public CheckoutResource(ProcessaPedidoPort processaPedidoPort) {
        this.processaPedidoPort = processaPedidoPort;
    }

    @PostMapping
    @Transactional
    ResponseEntity<?> recebePedido(@RequestBody RecebePedidoRequest request) {

        var pedido = this.processaPedidoPort.criarPedido(request.toPedido());

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/api/v1/pedidos/{id}")
                        .buildAndExpand("dsd")
                        .toUri()).body(new CheckoutResponse(pedido.getNumero(),pedido.getStatus()));
    }
}
