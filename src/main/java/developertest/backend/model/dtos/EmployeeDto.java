package developertest.backend.model.dtos;

public class EmployeeDto {

    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;

    public EmployeeDto()
    {
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
