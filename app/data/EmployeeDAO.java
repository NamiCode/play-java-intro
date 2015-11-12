package data;

import com.google.inject.ImplementedBy;
import models.Employee;

@ImplementedBy(InMemoryEmployeeDAO.class)
public interface EmployeeDAO extends DAO<Employee> {

}
