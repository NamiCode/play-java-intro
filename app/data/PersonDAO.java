package data;

import com.google.inject.ImplementedBy;
import models.Person;

import java.util.Optional;

@ImplementedBy(InMemoryPersonDAO.class)
public interface PersonDAO {

    Person save(Person p);

    Optional<Person> findById(String id);

}
