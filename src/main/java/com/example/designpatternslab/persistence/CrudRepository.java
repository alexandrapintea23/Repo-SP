
package com.example.designpatternslab.persistence;

import java.util.List;
import java.util.Optional;

// LAB 5-6 - Interfata proprie pentru operatiile CRUD
public interface CrudRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);

    boolean existsById(ID id);

    void deleteById(ID id);
}
