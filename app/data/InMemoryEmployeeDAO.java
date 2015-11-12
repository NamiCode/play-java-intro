package data;

import com.google.inject.Singleton;
import models.Employee;

@Singleton
public class InMemoryEmployeeDAO extends InMemoryDAO<Employee>
        implements EmployeeDAO {

}
