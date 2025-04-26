package com.loja.digital.service;

import com.loja.digital.model.Categoria;
import java.util.List;

/**
 * Define os casos de uso (serviços) relacionados à entidade Categoria.
 */
public interface CategoriaService {

    /**
     * Persiste uma nova categoria.
     *
     * @param categoria objeto contendo os dados da categoria a ser criada
     * @return categoria criada, com ID gerado
     */
    Categoria save(Categoria categoria);

    /**
     * Recupera todas as categorias cadastradas.
     *
     * @return lista de categorias
     */
    List<Categoria> findAll();


    Categoria findById(Long id);


    Categoria update(Long id, Categoria dados);

    void delete(Long id);
}
