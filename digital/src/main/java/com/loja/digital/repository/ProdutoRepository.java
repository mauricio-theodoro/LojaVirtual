package com.loja.digital.repository;

import com.loja.digital.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para Produto.
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}