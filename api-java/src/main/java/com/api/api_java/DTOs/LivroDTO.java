package com.api.api_java.DTOs;

import java.util.List;
import java.util.stream.Collectors;

import com.api.api_java.entity.Livro;

import lombok.Getter;

@Getter
public class LivroDTO {

    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;

    public LivroDTO(Livro livro) {
        isbn = livro.getIsbn();
        titulo = livro.getTitulo();
        edicao = livro.getEdicao();
        autor = livro.getAutor();
    }

    public static List<LivroDTO> converter(List<Livro> livros) {
        return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
