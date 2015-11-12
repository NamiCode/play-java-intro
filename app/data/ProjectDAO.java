package data;

import com.google.inject.ImplementedBy;
import models.Project;

@ImplementedBy(InMemoryProjectDAO.class)
public interface ProjectDAO extends DAO<Project> {
}
