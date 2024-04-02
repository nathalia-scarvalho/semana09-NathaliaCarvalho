package Curso.API.controller;

import Curso.API.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> listarProdutos(Pageable pageable) {
        Page<Produto> produtos = produtoService.listarProdutos(pageable);
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@RequestBody ProdutoCadDTO produtoDTO) {
        return produtoService.cadastrarProduto(produtoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @RequestBody ProdutoAtualDTO produtoDTO) {
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produtoDTO);
        return ProdutoDTO.fromProduto(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
