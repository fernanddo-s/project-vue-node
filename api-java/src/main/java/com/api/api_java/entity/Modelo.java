package com.api.api_java.entity;

public enum Modelo {
	FISICO("físico"), 
	EBOOK("ebook");

	private String descricao;

    Modelo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
