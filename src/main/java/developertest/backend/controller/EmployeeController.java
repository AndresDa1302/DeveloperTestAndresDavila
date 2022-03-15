package developertest.backend.controller;

import developertest.backend.model.entities.Employee;
import developertest.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/v1/" )
@CrossOrigin(origins = "*")
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

    @GetMapping( value= {"/employee/{id}","/employee"} )
    public ResponseEntity<List<Employee>> findById(@PathVariable (name="id",required = false)String id)  throws IOException {

        try
        {
            if(id != null)
            {
                List<Employee> employees=new ArrayList<>();
                employees.add(employeeService.findById(id));
                return ResponseEntity.ok().body(employees);
            }
            else
            {

                return ResponseEntity.ok().body(employeeService.all());
            }
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
