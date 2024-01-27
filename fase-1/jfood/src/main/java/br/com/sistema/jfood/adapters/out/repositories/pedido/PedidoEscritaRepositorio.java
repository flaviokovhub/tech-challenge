package br.com.sistema.jfood.adapters.out.repositories.pedido;

import br.com.sistema.jfood.adapters.out.repositories.pedido.entidade.PedidoEntity;
import br.com.sistema.jfood.adapters.out.repositories.pedido.mapper.PedidoMapper;
import br.com.sistema.jfood.core.application.ports.out.PedidoEscritaPort;
import br.com.sistema.jfood.core.domain.pedido.Pedido;
import org.springframework.stereotype.Component;

@Component
 class PedidoEscritaRepositorio implements PedidoEscritaPort {

    private final PedidoRepository pedidoRepository;

    public PedidoEscritaRepositorio(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return PedidoMapper.toPedido(
                this.pedidoRepository.save(new PedidoEntity(pedido))
        );
    }
}
