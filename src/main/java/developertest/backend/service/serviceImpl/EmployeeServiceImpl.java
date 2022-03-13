package developertest.backend.service.serviceImpl;

import developertest.backend.exception.EmployeeNotFoundException;
import developertest.backend.model.entities.Employee;
import developertest.backend.repository.EmployeeRepository;
import developertest.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeerepository;

    public EmployeeServiceImpl(@Autowired EmployeeRepository employeerepository)
    {
        this.employeerepository=employeerepository;
    }
    @Override
    public Employee findById(String id) throws EmployeeNotFoundException
        {
            Optional<Employee> optionalUser = employeerepository.findById( id );
            if ( optionalUser.isPresent() )
            {
                return optionalUser.get();
            }
            else
            {
                throw new EmployeeNotFoundException();
            }
        }



    @Override
    public List<Employee> all() {
        return employeerepository.findAll();
    }
}
