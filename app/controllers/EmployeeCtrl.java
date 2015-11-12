package controllers;

import data.EmployeeDAO;
import models.Employee;

import javax.inject.Inject;

public class EmployeeCtrl extends AbstractCtrl<Employee> {

    @Inject
    public EmployeeCtrl(EmployeeDAO dao) {
        super(dao);
    }

    protected Class<Employee> getEntityType() {
        return Employee.class;
    }

    protected boolean validate(Employee e) {
        return !(e == null
                || e.name == null
                || e.salary < 1000
                || e.skills == null
                || e.skills.isEmpty());
    }
}
