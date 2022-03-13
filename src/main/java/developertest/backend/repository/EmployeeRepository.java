package developertest.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import developertest.backend.model.entities.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
}