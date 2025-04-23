package com.loja.digital.controller;

import com.loja.digital.model.Categoria;
import com.loja.digital.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controller que expõe os endpoints REST para Categoria.
 */
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Endpoint para listar todas as categorias.
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.findAll();
    }

    // Endpoint para buscar uma categoria pelo id.
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar uma nova categoria.
    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    // Endpoint para atualizar uma categoria existente.
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetalhes) {
        try {
            Categoria categoriaAtualizada = categoriaService.update(id, categoriaDetalhes);
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar uma categoria.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        try {
            categoriaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
