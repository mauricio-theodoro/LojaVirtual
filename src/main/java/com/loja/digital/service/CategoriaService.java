package com.loja.digital.service;

import com.loja.digital.model.Categoria;
import java.util.List;
import java.util.Optional;

/**
 * Define os métodos de negócio para a entidade Categoria.
 */
public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Long id, Categoria categoria);
    void delete(Long id);
}
