package developertest.backend.model.entities;

import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import developertest.backend.model.dtos.EmployeeDto;

import java.math.BigInteger;

@Document
public class Employee {

    @Id
    Number id;
    String employee_name;
    BigInteger employee_salary;
    int employee_age;
    String profile_image;
    BigInteger employee_anual_salary;

    public Employee()
    {
    }
    public Employee (EmployeeDto EmployeeDto)
    {
        employee_name=EmployeeDto.getEmployee_name();
        employee_salary=EmployeeDto.getEmployee_salary();
        employee_age=EmployeeDto.getEmployee_age();
        profile_image=EmployeeDto.getProfile_image();
        employee_anual_salary=EmployeeDto.getEmployee_anual_salary();
    }
    public Employee(JSONObject json)
    {
        id=json.getNumber("id");
        employee_name = json.getString("employee_name");
        employee_salary= json.getBigInteger("employee_salary");
        employee_age= json.getInt("employee_age");
        employee_anual_salary=employee_salary.multiply(new BigInteger(String.valueOf("12")));

    }
    public void setId(Number id) {
        this.id = id;
    }

    public Number getId() {
        return id;
    }

    public BigInteger getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(BigInteger employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public BigInteger getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(BigInteger employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary.multiply(new BigInteger(String.valueOf(12)));
    }
    public String toString()
    {
        return "{"+ " id='" + getId() + "'" + ", employee_name='" + getEmployee_name() + "'" + ", employee_age='" + getEmployee_age() + "'"
                + ", profile_image='" + getProfile_image() + "'" + ", employee_anual_salary='" + getEmployee_anual_salary() + "'" + "}";

    }
}
