package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    T update(ID id, T entity);

    boolean deleteById(ID id);

    boolean existsById(ID id);

    long count();
}