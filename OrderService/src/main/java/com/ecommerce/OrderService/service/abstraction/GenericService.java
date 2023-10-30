package com.ecommerce.OrderService.service.abstraction;

import com.ecommerce.OrderService.repository.abstraction.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class GenericService<T, ID> {

    @Autowired
    public GenericRepository<T, ID> repository;

    public T create(T entity) {
        return repository.save(entity);
    }

    public T read(ID id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Elemento con ID "+id+ " non trovato.")
        );
    }

    public T update(T entity) {
        return repository.save(entity);
    }
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void deleteByEntity(T entity) {
        repository.delete(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
