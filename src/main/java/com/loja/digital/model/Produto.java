package com.loja.digital.model;

import jakarta.persistence.*;



/**
 * A classe Produto representa um produto ofertado na loja digital.
 * Cada produto pertence a uma categoria.
 */
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    private String descricao;

    // Mapeamento Many-to-One: Vários produtos podem pertencer a uma única categoria.
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Construtor padrão
    public Produto() {}

    // Construtor com argumentos
    public Produto(String nome, Double preco, String descricao, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Método toString que exibe o nome da Categoria (evitando recursão indireta)
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + (categoria != null ? categoria.getNome() : null) +
                '}';
    }
}
