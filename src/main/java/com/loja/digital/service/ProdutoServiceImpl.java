package com.loja.digital.service;

import com.loja.digital.model.Produto;
import com.loja.digital.model.Categoria;
import com.loja.digital.repository.ProdutoRepository;
import com.loja.digital.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

/**
 * Implementação dos métodos de negócio para Produto.
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto save(Produto produto) {
        if(produto.getCategoria() != null) {
            Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoria().getId());
            if(categoria.isPresent()){
                produto.setCategoria(categoria.get());
            } else {
                throw new RuntimeException("Categoria informada não existe.");
            }
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto update(Long id, Produto produtoDetails) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()){
            Produto existingProduto = optionalProduto.get();
            existingProduto.setNome(produtoDetails.getNome());
            existingProduto.setPreco(produtoDetails.getPreco());
            existingProduto.setDescricao(produtoDetails.getDescricao());
            if(produtoDetails.getCategoria() != null) {
                Optional<Categoria> categoria = categoriaRepository.findById(produtoDetails.getCategoria().getId());
                if(categoria.isPresent()){
                    existingProduto.setCategoria(categoria.get());
                } else {
                    throw new RuntimeException("Categoria informada para atualização não existe.");
                }
            }
            return produtoRepository.save(existingProduto);
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }
}
