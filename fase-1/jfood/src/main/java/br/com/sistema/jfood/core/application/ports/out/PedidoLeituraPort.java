package br.com.sistema.jfood.core.application.ports.out;

import br.com.sistema.jfood.core.domain.pedido.Pedido;

import java.util.List;

public interface PedidoLeituraPort {
    List<Pedido> listarPedidos();
}
