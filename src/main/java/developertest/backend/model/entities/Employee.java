package developertest.backend.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import developertest.backend.model.dtos.EmployeeDto;

@Document
public class Employee {

    @Id
    String id;
    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;

    public Employee()
    {
    }
    public Employee (EmployeeDto EmployeeDto)
    {
        employee_name=EmployeeDto.getEmployee_name();
        employee_salary=EmployeeDto.getEmployee_salary();
        employee_age=EmployeeDto.getEmployee_age();
        profile_image=EmployeeDto.getProfile_image();
    }
    public String getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }
    
}
