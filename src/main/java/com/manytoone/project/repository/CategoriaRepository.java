package com.manytoone.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.manytoone.project.domain.Categoria;

public interface  CategoriaRepository  extends CrudRepository<Categoria, Long>{
    
}
