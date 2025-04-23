package com.loja.digital.service;

import com.loja.digital.model.Produto;
import java.util.List;
import java.util.Optional;

/**
 * Define os métodos de negócio para a entidade Produto.
 */
public interface ProdutoService {
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    Produto save(Produto produto);
    Produto update(Long id, Produto produto);
    void delete(Long id);
}
