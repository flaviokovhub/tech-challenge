package br.com.sistema.jfood.adapters.out.repositories.pedido;

import br.com.sistema.jfood.adapters.out.repositories.pedido.entidade.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

 interface PedidoRepository extends JpaRepository<PedidoEntity,Long> {
}
