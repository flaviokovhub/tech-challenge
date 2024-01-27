package br.com.sistema.jfood.core.application.ports.in.pedido;

import br.com.sistema.jfood.core.domain.pedido.Pedido;

import java.util.List;

public interface ProcessaPedidoPort {
    Pedido criarPedido(Pedido pedido);

    List<Pedido> listarPedidos();
}
