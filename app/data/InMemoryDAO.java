package data;

import models.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public abstract class InMemoryDAO<T extends Entity> implements DAO<T> {

    private final Map<String, T> entities = new HashMap<>();

    public T save(T entity) {
        if (entity.id == null) entity.id = UUID.randomUUID().toString();
        entities.put(entity.id, entity);
        return entity;
    }

    public Optional<T> get(String id) {
        return Optional.ofNullable(entities.get(id));
    }

}
