package br.com.sistema.jfood.adapters.in.resources.pedido.request;

import br.com.sistema.jfood.core.domain.pagamento.TipoPagamento;

import java.math.BigDecimal;

public record PagamentoRequest(
        TipoPagamento tipoPagamento,

        BigDecimal valor
) {
}
