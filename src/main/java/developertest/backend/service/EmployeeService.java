package developertest.backend.service;

import developertest.backend.exception.EmployeeNotFoundException;
import developertest.backend.model.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(String id )
            throws EmployeeNotFoundException;


    List<Employee> all();


}
