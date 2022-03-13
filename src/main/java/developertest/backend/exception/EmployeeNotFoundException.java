package developertest.backend.exception;


import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException
        extends InternalServerErrorException
{
    public EmployeeNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND ),
                HttpStatus.NOT_FOUND );
    }
}
