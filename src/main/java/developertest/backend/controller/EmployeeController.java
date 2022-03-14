package developertest.backend.controller;

import developertest.backend.model.entities.Employee;
import developertest.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping( "/v1/" )
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController( @Autowired EmployeeService employeeService )
    {
        this.employeeService = employeeService;
    }
    @GetMapping( "/employees" )
    public List<Employee> all() throws IOException {
        return employeeService.all();
    }

    @GetMapping( "/employee/{id}" )
    public Employee findById( @PathVariable String id ) throws IOException {
        return employeeService.findById( id );
    }
}
