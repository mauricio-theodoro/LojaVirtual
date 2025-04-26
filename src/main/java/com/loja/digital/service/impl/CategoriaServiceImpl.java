package com.loja.digital.service.impl;

import com.loja.digital.exception.ResourceNotFoundException;
import com.loja.digital.model.Categoria;
import com.loja.digital.repository.CategoriaRepository;
import com.loja.digital.service.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementação de CategoriaService, com injeção por construtor
 * e controle de transações.
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    /**
     * Construtor que injeta o CategoriaRepository.
     * @param categoriaRepository repositório de categorias
     */
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada com id: " + id));
    }

    @Override
    @Transactional
    public Categoria update(Long id, Categoria dados) {
        Categoria existente = findById(id);
        existente.setNome(dados.getNome());
        existente.setDescricao(dados.getDescricao());
        return categoriaRepository.save(existente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Categoria existente = findById(id);
        categoriaRepository.delete(existente);
    }
}
