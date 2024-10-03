package com.api.api_java.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_java.DTOs.AtualizaLivroFormDTO;
import com.api.api_java.DTOs.DetalhesLivroDTO;
import com.api.api_java.DTOs.LivroDTO;
import com.api.api_java.DTOs.LivroFormDTO;
import com.api.api_java.entity.Livro;
import com.api.api_java.repository.LivroRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroDTO> listar() {
        List<Livro> livros = livroRepository.findAll();
        return LivroDTO.converter(livros);
    }

    @Transactional
    @PostMapping
    public LivroDTO salvar(@RequestBody LivroFormDTO form) {
        Livro livro = form.converter();
        livroRepository.save(livro);
        return new LivroDTO(livro);
    }

    @Transactional
    @GetMapping("/{isbn}")
    public Optional<Livro> findById(@PathVariable Long isbn) {

        final Optional<Livro> livro = livroRepository.findById(isbn);
        return livro;
    }

    @Transactional
    @PutMapping("/{isbn}")
    public DetalhesLivroDTO atualizar(@PathVariable Long isbn, @RequestBody AtualizaLivroFormDTO form) {

        final Optional<Livro> optLivro = livroRepository.findById(isbn);

        if (optLivro.isPresent()) {
            Livro livro = optLivro.get();
            form.atualiza(livro);
            livroRepository.save(livro);
            return new DetalhesLivroDTO(livro);
        }

        System.out.println("Livro não encontrado");
        return null;
    }


    @Transactional
    @DeleteMapping("/{isbn}")
    public void deletar(@PathVariable Long isbn) {

        final Optional<Livro> optLivro = livroRepository.findById(isbn);

        if (optLivro.isPresent()) {
            livroRepository.deleteById(isbn);
        }

    }

}
