package controllers;

import models.Project;
import data.ProjectDAO;

import javax.inject.Inject;

public class ProjectCtrl extends AbstractCtrl<Project> {

    @Inject
    public ProjectCtrl(ProjectDAO dao) {
        super(dao);
    }

    protected Class getEntityType() {
        return Project.class;
    }

    protected boolean validate(Project project) {
        return project.name != null
                && !project.name.isEmpty()
                && project.requiredSkills != null
                && !project.requiredSkills.isEmpty();
    }

}
