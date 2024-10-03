package com.api.api_java.DTOs;

import com.api.api_java.entity.Categoria;
import com.api.api_java.entity.Livro;
import com.api.api_java.entity.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LivroFormDTO {

    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    private String categoria;
    private String modelo;

    public Livro converter() {
        Livro livro = new Livro();
        livro.setIsbn(isbn);
        livro.setAutor(autor);
        livro.setCategoria(Categoria.valueOf(categoria));
        livro.setEdicao(edicao);
        livro.setModelo(Modelo.valueOf(modelo));
        livro.setTitulo(titulo);
        return livro;
    }
}
