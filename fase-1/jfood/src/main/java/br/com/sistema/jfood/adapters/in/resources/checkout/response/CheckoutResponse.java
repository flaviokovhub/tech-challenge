package br.com.sistema.jfood.adapters.in.resources.checkout.response;

import br.com.sistema.jfood.core.domain.pedido.Status;

public record CheckoutResponse(
        long numero,
        Status status
) {
}
