package models;

import java.util.HashSet;
import java.util.Set;

public class Project extends Entity {

    public String name;

    public Set<Skill> requiredSkills = new HashSet<>();

}
