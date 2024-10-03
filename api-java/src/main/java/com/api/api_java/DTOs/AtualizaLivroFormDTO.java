package com.api.api_java.DTOs;

import com.api.api_java.entity.Categoria;
import com.api.api_java.entity.Livro;
import com.api.api_java.entity.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AtualizaLivroFormDTO {

    private String categoria;
    private String modelo;

    public void atualiza(Livro livro) {
        livro.setCategoria(Categoria.valueOf(categoria));
        livro.setModelo(Modelo.valueOf(modelo));
    }
}