package com.lojadigital.repository;

import com.lojadigital.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Categoria.
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
