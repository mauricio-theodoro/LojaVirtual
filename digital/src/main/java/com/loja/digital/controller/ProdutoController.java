package com.loja.digital.controller;

import com.loja.digital.model.Produto;
import com.loja.digital.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

/**
 * Controller que expõe os endpoints REST para Produto.
 */
@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para listar todos os produtos.
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.findAll();
    }

    // Endpoint para buscar um produto pelo id.
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo produto.
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        try {
            Produto novoProduto = produtoService.save(produto);
            return ResponseEntity.ok(novoProduto);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para atualizar um produto existente.
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoDetalhes) {
        try {
            Produto produtoAtualizado = produtoService.update(id, produtoDetalhes);
            return ResponseEntity.ok(produtoAtualizado);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um produto.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        try {
            produtoService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
