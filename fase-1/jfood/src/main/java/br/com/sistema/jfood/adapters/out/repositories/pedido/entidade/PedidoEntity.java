package br.com.sistema.jfood.adapters.out.repositories.pedido.entidade;

import br.com.sistema.jfood.core.domain.pagamento.TipoPagamento;
import br.com.sistema.jfood.core.domain.pedido.Pedido;
import br.com.sistema.jfood.core.domain.pedido.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity(name = "Pedido")
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ItemPedidoEntity> itens = new ArrayList<>();

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    public PedidoEntity() {
    }

    public PedidoEntity(Pedido pedido) {
        this.dataPedido = pedido.getData();
        this.total = pedido.getValor();
        this.status = pedido.getStatus();
        this.tipoPagamento = pedido.getTipoPagamento();
        this.cpf = pedido.getCliente().getCpf();
        this.itens = pedido.getItensPedido().stream().map(i -> new ItemPedidoEntity(i,this)).collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ItemPedidoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoEntity> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoEntity that = (PedidoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
