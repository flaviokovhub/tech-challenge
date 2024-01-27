package br.com.sistema.jfood.core.domain.pedido;

import br.com.sistema.jfood.core.domain.cliente.Cliente;
import br.com.sistema.jfood.core.domain.pagamento.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Pedido {
    private final long numero;
    private final LocalDateTime data;
    private final List<ItemPedido> itensPedido;
    private final Cliente cliente;
    private final BigDecimal valor;
    private final Status status;

    private final TipoPagamento tipoPagamento;

    private Pedido(Builder builder) {
        this.numero = builder.numero;
        this.data = LocalDateTime.now();
        this.itensPedido = builder.itemPedidos;
        this.status = builder.status;
        this.valor = builder.valor;
        this.cliente = builder.cliente;
        this.tipoPagamento = builder.tipoPagamento;
    }

    public static class Builder {
        private TipoPagamento tipoPagamento;
        private List<ItemPedido> itemPedidos;
        private Cliente cliente;
        private BigDecimal valor;
        private Status status;
        private long numero;

        private LocalDateTime data;

        public Builder comData(LocalDateTime data) {
            this.data = data;
            return this;
        }
        public Builder comNumero(long numero) {
            this.numero = numero;
            return this;
        }

        public Builder comTipoPagamento(TipoPagamento tipoPagamento) {
            this.tipoPagamento = tipoPagamento;
            return this;
        }

        public Builder comItensPedido(List<ItemPedido> itemPedidos) {
            this.itemPedidos = itemPedidos;
            return this;
        }

        public Builder comValor(double valor) {
            this.valor = BigDecimal.valueOf(valor);
            return this;
        }

        public Builder comCliente(String cpf) {
            this.cliente = new Cliente(cpf);
            return this;
        }

        public Builder comStatus(Status status) {
            this.status = status;
            return this;
        }

        public Pedido build() {
            return new Pedido(this);
        }
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Status getStatus() {
        return status;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public long getNumero() {
        return numero;
    }
}
