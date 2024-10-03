package com.api.api_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api_java.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
