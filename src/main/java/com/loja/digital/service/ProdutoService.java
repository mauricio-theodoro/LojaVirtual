package com.loja.digital.service;

import com.loja.digital.model.Produto;
import java.util.List;

/**
 * Define os casos de uso (serviços) relacionados à entidade Produto.
 */
public interface ProdutoService {

    Produto save(Produto produto);


    List<Produto> findAll();
    Produto findById(Long id);


    Produto update(Long id, Produto dados);


    void delete(Long id);
}
