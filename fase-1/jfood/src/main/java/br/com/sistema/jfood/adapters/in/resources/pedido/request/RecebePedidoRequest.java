package br.com.sistema.jfood.adapters.in.resources.pedido.request;

import br.com.sistema.jfood.core.domain.pagamento.TipoPagamento;
import br.com.sistema.jfood.core.domain.pedido.Pedido;
import br.com.sistema.jfood.core.domain.pedido.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public record RecebePedidoRequest(

        @JsonProperty("items_pedido")
        List<ItemPedidoRequest> itemsPedido,
        String cpf

        //PagamentoRequest pagamento


) {

    public Pedido toPedido() {
        return new Pedido.Builder()
                .comItensPedido(itemsPedido.stream().map(ItemPedidoRequest::toItemPedido).collect(Collectors.toList()))
                .comStatus(Status.RECEBIDO)
                .comValor(itemsPedido.stream().mapToDouble(ItemPedidoRequest::preco).sum())
                .comCliente(cpf)
                .comTipoPagamento(TipoPagamento.QR_CODE)
                .build();
    }
}
