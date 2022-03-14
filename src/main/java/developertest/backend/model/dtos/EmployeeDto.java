package developertest.backend.model.dtos;

import java.math.BigInteger;

public class EmployeeDto {

    String employee_name;
    BigInteger employee_salary;
    int employee_age;
    String profile_image;
    BigInteger employee_anual_salary;

    public EmployeeDto()
    {
    }

    public BigInteger getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public String getEmployee_name() {
        return employee_name;
    }


    public BigInteger getEmployee_salary() {
        return employee_salary;
    }



    public int getEmployee_age() {
        return employee_age;
    }



    public String getProfile_image() {
        return profile_image;
    }


}
