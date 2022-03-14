package developertest.backend.service;

import developertest.backend.exception.EmployeeNotFoundException;
import developertest.backend.model.entities.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    Employee findById(String id )
            throws EmployeeNotFoundException, IOException;


    List<Employee> all() throws IOException;


}
