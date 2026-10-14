package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import java.util.*;
import java.util.function.Function;

public class InMemoryRepository<T, ID>
        implements CrudRepository<T, ID> {

    private final Map<ID, T> database = new HashMap<>();

    private final Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public T save(T entity) {
        ID id = Objects.requireNonNull(
                idExtractor.apply(entity),
                "Entity ID cannot be null"
        );

        database.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public T update(ID id, T entity) {

        if (!database.containsKey(id)) {
            throw new NoSuchElementException(
                    "Entity not found: " + id
            );
        }

        if (!Objects.equals(id, idExtractor.apply(entity))) {
            throw new IllegalArgumentException(
                    "Entity ID mismatch"
            );
        }

        database.put(id, entity);
        return entity;
    }

    @Override
    public boolean deleteById(ID id) {
        return database.remove(id) != null;
    }

    @Override
    public boolean existsById(ID id) {
        return database.containsKey(id);
    }

    @Override
    public long count() {
        return database.size();
    }
}