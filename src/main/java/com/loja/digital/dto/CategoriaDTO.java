package com.loja.digital.dto;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private List<Long> idsProdutos;

    // Construtor padrão
    public CategoriaDTO() {}

    // Construtor baseado na entidade Categoria
    public CategoriaDTO(com.loja.digital.model.Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        if (categoria.getProdutos() != null) {
            this.idsProdutos = categoria.getProdutos()
                    .stream()
                    .map(produto -> produto.getId())
                    .collect(Collectors.toList());
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Long> getIdsProdutos() {
        return idsProdutos;
    }

    public void setIdsProdutos(List<Long> idsProdutos) {
        this.idsProdutos = idsProdutos;
    }
}
