package br.com.sistema.jfood.core.domain.pedido;

public record ItemPedido(
        String nome,
        String descricao,
        String categoria,
        int quantidade,
        double valor
) {
}
