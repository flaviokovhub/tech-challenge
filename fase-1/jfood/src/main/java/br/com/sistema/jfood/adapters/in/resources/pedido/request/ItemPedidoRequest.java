package br.com.sistema.jfood.adapters.in.resources.pedido.request;

import br.com.sistema.jfood.core.domain.pedido.ItemPedido;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemPedidoRequest(
        String nome,
        String descricao,
        String categoria,
        @Min(1)
        int quantidade,
        @NotNull
        @DecimalMin(value = "0", inclusive = false)
        double preco
) {
        public ItemPedido toItemPedido() {
                return new ItemPedido(
                        nome,
                        descricao,
                        categoria,
                        quantidade,
                        preco);
        }
}
