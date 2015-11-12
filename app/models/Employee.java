package models;

import java.util.HashSet;
import java.util.Set;

public class Employee extends Entity {

    public String name;
    public int salary;
    public Set<Skill> skills = new HashSet<>();

}
