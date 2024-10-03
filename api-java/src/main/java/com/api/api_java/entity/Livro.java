package com.api.api_java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livro {
	@Id
    private Long isbn;
	private String titulo;
	private Integer edicao;
	private String autor;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	private Modelo modelo;
}
