package com.loja.digital.controller;

import com.loja.digital.model.Categoria;
import com.loja.digital.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para gerenciar operações de Categoria.
 */
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    /**
     * Lista todas as categorias cadastradas.
     *
     * @return lista de Categoria
     */
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.findAll();
    }

    /**
     * Busca uma categoria pelo ID.
     * Lança ResourceNotFoundException se não encontrar → mapeado para 404.
     *
     * @param id identificador da Categoria
     * @return Categoria encontrada
     */
    @GetMapping("/{id}")
    public Categoria buscarCategoria(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(
            @PathVariable Long id,
            @RequestBody Categoria categoriaDetalhes) {
        return categoriaService.update(id, categoriaDetalhes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}
