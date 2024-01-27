package br.com.sistema.jfood.adapters.in.resources.produto;

import br.com.sistema.jfood.adapters.in.resources.produto.request.AtualizarProdutoRequest;
import br.com.sistema.jfood.adapters.in.resources.produto.request.CategoriaRequest;
import br.com.sistema.jfood.adapters.in.resources.produto.request.CriarProdutoRequest;
import br.com.sistema.jfood.adapters.in.resources.produto.response.ListarProdutosResponse;
import br.com.sistema.jfood.adapters.in.resources.produto.response.ProdutoAtualizadoResponse;
import br.com.sistema.jfood.adapters.in.resources.produto.response.ProdutoCriadoResponse;
import br.com.sistema.jfood.adapters.in.resources.produto.validacao.ValidaCategoria;
import br.com.sistema.jfood.core.application.ports.in.produto.ConsultaProdutoPort;
import br.com.sistema.jfood.core.application.ports.in.produto.CriarProdutoPort;
import br.com.sistema.jfood.core.domain.produtos.Categoria;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/produtos")
@Validated
public class ProdutoResource {

    private final CriarProdutoPort criarProdutoPort;

    private final ConsultaProdutoPort consultaProdutoPort;

    public ProdutoResource(CriarProdutoPort criarProdutoPort, ConsultaProdutoPort consultaProdutoPort) {
        this.criarProdutoPort = criarProdutoPort;
        this.consultaProdutoPort = consultaProdutoPort;
    }

    @PostMapping
    @Transactional
    ResponseEntity<?> criarProduto(@RequestBody @Valid CriarProdutoRequest request) {

        var produto = this.criarProdutoPort.criarProduto(request.toProduto());

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/api/v1/produtos/{id}")
                        .buildAndExpand(produto.getId().toString())
                        .toUri()).body(new ProdutoCriadoResponse(produto.getId().toString())
        );
    }

    @GetMapping
    @Transactional(readOnly = true)
    ResponseEntity<?> buscarProdutoPorCategoria(@RequestParam(name = "categoria") CategoriaRequest categoria) {

        return ResponseEntity.ok( this.consultaProdutoPort.buscaProdutosPorCategoria(categoria.name())
                .stream()
                .map(ListarProdutosResponse::mapper)
                .collect(Collectors.toList())
        );

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    void deletarProduto(@PathVariable @Valid String id) {
        this.criarProdutoPort.deletarProduto(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> atualizarProduto(@RequestBody @Valid AtualizarProdutoRequest request, @PathVariable UUID id ) {
        return ResponseEntity.ok(ProdutoAtualizadoResponse.mapper( this.criarProdutoPort.atualizarProduto(request.toProdutoCom(id))));
    }
}
