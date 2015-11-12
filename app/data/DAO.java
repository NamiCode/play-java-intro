package data;

import models.Entity;

import java.util.Optional;

public interface DAO<T extends Entity> {

    T save(T entity);

    Optional<T> get(String id);

}
