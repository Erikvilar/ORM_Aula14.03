package com.manytoone.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.manytoone.project.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

    

    
}
