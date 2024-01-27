package br.com.sistema.jfood.core.domain.pagamento;

import java.math.BigDecimal;

public record Pagamento(
        TipoPagamento tipo,
        BigDecimal valor
) {

}
