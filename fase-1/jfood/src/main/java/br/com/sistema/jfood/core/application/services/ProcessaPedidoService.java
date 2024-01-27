package br.com.sistema.jfood.core.application.services;

import br.com.sistema.jfood.core.application.ports.in.pedido.ProcessaPedidoPort;
import br.com.sistema.jfood.core.application.ports.out.PedidoEscritaPort;
import br.com.sistema.jfood.core.application.ports.out.PedidoLeituraPort;
import br.com.sistema.jfood.core.domain.pedido.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessaPedidoService implements ProcessaPedidoPort {

   private final PedidoEscritaPort pedidoEscritaPort;

   private final PedidoLeituraPort pedidoLeituraPort;

    public ProcessaPedidoService(PedidoEscritaPort pedidoEscritaPort, PedidoLeituraPort pedidoLeituraPort) {
        this.pedidoEscritaPort = pedidoEscritaPort;
        this.pedidoLeituraPort = pedidoLeituraPort;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return this.pedidoEscritaPort.criarPedido(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return this.pedidoLeituraPort.listarPedidos();
    }
}
