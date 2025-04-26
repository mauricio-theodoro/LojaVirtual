package com.loja.digital.service.impl;

import com.loja.digital.exception.ResourceNotFoundException;
import com.loja.digital.model.Categoria;
import com.loja.digital.model.Produto;
import com.loja.digital.repository.CategoriaRepository;
import com.loja.digital.repository.ProdutoRepository;
import com.loja.digital.service.ProdutoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementação de ProdutoService, com injeção por construtor
 * e validação de categoria.
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    /**
     * Construtor que injeta os repositórios.
     */
    public ProdutoServiceImpl(ProdutoRepository produtoRepository,
                              CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional
    public Produto save(Produto produto) {
        Long catId = produto.getCategoria().getId();
        Categoria categoria = categoriaRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada com id: " + catId));
        produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Produto não encontrado com id: " + id));
    }

    @Override
    @Transactional
    public Produto update(Long id, Produto dados) {
        Produto existente = findById(id);
        existente.setNome(dados.getNome());
        existente.setDescricao(dados.getDescricao());
        existente.setPreco(dados.getPreco());

        Long catId = dados.getCategoria().getId();
        Categoria categoria = categoriaRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada com id: " + catId));
        existente.setCategoria(categoria);

        return produtoRepository.save(existente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Produto existente = findById(id);
        produtoRepository.delete(existente);
    }
}
