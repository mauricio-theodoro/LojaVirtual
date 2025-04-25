package com.lojadigital.service;

import com.lojadigital.model.Categoria;
import com.lojadigital.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Implementação dos métodos de negócio para Categoria.
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoriaDetails) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if(optional.isPresent()){
            Categoria existingCategoria = optional.get();
            existingCategoria.setNome(categoriaDetails.getNome());
            existingCategoria.setDescricao(categoriaDetails.getDescricao());
            return categoriaRepository.save(existingCategoria);
        } else {
            throw new RuntimeException("Categoria não encontrada com o id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Categoria não encontrada com o id: " + id);
        }
    }
}
