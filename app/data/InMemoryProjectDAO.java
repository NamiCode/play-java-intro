package data;

import models.Project;

import javax.inject.Singleton;

@Singleton
public class InMemoryProjectDAO extends InMemoryDAO<Project>
        implements ProjectDAO {
}
