package br.com.sistema.jfood.adapters.out.repositories.pedido.mapper;

import br.com.sistema.jfood.adapters.out.repositories.pedido.entidade.ItemPedidoEntity;
import br.com.sistema.jfood.adapters.out.repositories.pedido.entidade.PedidoEntity;
import br.com.sistema.jfood.core.domain.pedido.Pedido;

import java.util.stream.Collectors;

public class PedidoMapper {

    public static Pedido toPedido(PedidoEntity entity) {
        return new Pedido.Builder()
                    .comNumero(entity.getId())
                    .comStatus(entity.getStatus())
                    .build();
    }

    public static Pedido toListaPedido(PedidoEntity entity) {
        return new Pedido.Builder()
                .comNumero(entity.getId())
                .comStatus(entity.getStatus())
                .comTipoPagamento(entity.getTipoPagamento())
                .comCliente(entity.getCpf())
                .comValor(entity.getTotal().doubleValue())
                .comData(entity.getDataPedido())
                .comItensPedido(entity.getItens().stream().map(ItemPedidoEntity::toItemPedido).collect(Collectors.toList()))
                .build();
    }
}
