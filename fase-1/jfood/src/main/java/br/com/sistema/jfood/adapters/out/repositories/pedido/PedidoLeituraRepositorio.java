package br.com.sistema.jfood.adapters.out.repositories.pedido;

import br.com.sistema.jfood.adapters.out.repositories.pedido.mapper.PedidoMapper;
import br.com.sistema.jfood.core.application.ports.out.PedidoLeituraPort;
import br.com.sistema.jfood.core.domain.pedido.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
 class PedidoLeituraRepositorio implements PedidoLeituraPort {

    private final PedidoRepository pedidoRepository;

    public PedidoLeituraRepositorio(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return this.pedidoRepository.findAll().stream()
                .map(p -> PedidoMapper.toListaPedido(p))
                .collect(Collectors.toList());
    }
}
