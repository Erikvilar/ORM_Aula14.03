package com.manytoone.project.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytoone.project.domain.Categoria;
import com.manytoone.project.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<Categoria> getAll() {
        try {
            List<Categoria> items = new ArrayList<Categoria>();

            // O método findAll() retorna um Iterable que é percorrido com o método
            // forEach() que adiciona cada item à lista items.
            // O operador :: é usado para criar expressões lambda mais claras e concisas.
            // A expressão lambda items::add é usada para adicionar cada item retornado pelo
            // método findAll() à lista items.
            // A expressão lambda items::add é equivalente a: (item) -> items.add(item)
            repository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Categoria getById(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        }
        return null;
    }

    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Long id, Categoria item) {
        Optional<Categoria> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            Categoria existingItem = existingItemOptional.get();
            existingItem.setNome(item.getNome());
            return repository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
