package br.com.sistema.jfood.core.application.ports.out;

import br.com.sistema.jfood.core.domain.pedido.Pedido;

public interface PedidoEscritaPort {
    Pedido criarPedido(Pedido pedido);
}
