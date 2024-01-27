package br.com.sistema.jfood.adapters.out.repositories.produto;

import br.com.sistema.jfood.adapters.out.repositories.produto.entidade.ProdutoEntity;
import br.com.sistema.jfood.core.domain.produtos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

 interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    List<ProdutoEntity> findAllByCategoria(Categoria categoria);
}
