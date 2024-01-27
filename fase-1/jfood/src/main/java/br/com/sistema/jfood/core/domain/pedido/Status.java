package br.com.sistema.jfood.core.domain.pedido;

public enum Status {

    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),

    PRONTO("Pronto"),

    FINALIZADO("Finalizado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
