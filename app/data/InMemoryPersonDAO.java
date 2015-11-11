package data;

import models.Person;

import javax.inject.Singleton;
import java.util.*;

@Singleton
public class InMemoryPersonDAO implements PersonDAO {

    private final Map<String, Person> people = new HashMap<>();

    public Person save(Person p) {
        if (p.id == null) p.id = UUID.randomUUID().toString();
        people.put(p.id, p);
        return p;
    }

    public Optional<Person> findById(String id) {
        return Optional.ofNullable(people.get(id));
    }

}
