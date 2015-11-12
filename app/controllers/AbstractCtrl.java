package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import data.DAO;
import models.Entity;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Optional;

public abstract class AbstractCtrl<T extends Entity>
        extends Controller {

    private final DAO<T> dao;

    public AbstractCtrl(DAO<T> dao) {
        this.dao = dao;
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result post() {
        JsonNode json = request().body().asJson();
        T entity;
        try {
            entity = Json.fromJson(json, getEntityType());
        } catch (RuntimeException exception) {
            return badRequest(exception.getMessage());
        }
        if (!validate(entity)) return badRequest();
        T saved = dao.save(entity);
        return created(Json.toJson(saved));
    }

    public Result get(String id) {
        Optional<T> maybeEntity = dao.get(id);
        if (maybeEntity.isPresent())
            return ok(Json.toJson(maybeEntity.get()));
        else
            return notFound("No " + getEntityType().getSimpleName() + " found for id " + id);
    }

    protected abstract Class<T> getEntityType();

    protected abstract boolean validate(T entity);

}
