package controllers;

import data.PersonDAO;
import models.Person;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Optional;

import static play.libs.Json.toJson;

public class PersonCtrl extends Controller {

    private final PersonDAO personDAO;

    @Inject
    public PersonCtrl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result post() {
        Person p = Json.fromJson(request().body().asJson(), Person.class);
        if (p.name == null) {
            return badRequest("Missing parameter [name]");
        } else {
            personDAO.save(p);
            return created(toJson(p));
        }
    }

    public Result get(String id) {
        Optional<Person> maybePerson = personDAO.findById(id);
        if (maybePerson.isPresent()) return ok(toJson(maybePerson.get()));
        else return notFound("No person found with id " + id);
    }


}
