package developertest.backend.service.serviceImpl;

import com.google.gson.Gson;
import developertest.backend.exception.EmployeeNotFoundException;
import developertest.backend.model.entities.Employee;
import developertest.backend.repository.EmployeeRepository;
import developertest.backend.service.EmployeeService;
import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    public String connectApi(String id) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("http://dummy.restapiexample.com/api/v1/employee/"+ id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(999999999);
        conn.setReadTimeout(999999999);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for (String line; (line = reader.readLine()) != null;) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ha ocurrido un error");
        }
        return result.toString();
    }

    @Override
    public Employee findById(String id) throws EmployeeNotFoundException,IOException
        {
            String ans=connectApi(id);
            JSONObject jsonObj = new JSONObject(ans);
            JSONObject res = jsonObj.getJSONObject("data");
            String name = res.getString("employee_name");
            int employee_age= res.getInt("employee_age");
            BigInteger employee_salary= res.getBigInteger("employee_salary");
            Number idd=res.getNumber("id");
            Employee employee= new Employee();
            employee.setEmployee_age(employee_age);
            employee.setEmployee_name(name);
            employee.setId(idd);
            employee.setEmployee_salary(employee_salary);
            employee.setProfile_image(null);
            employee.setEmployee_anual_salary(employee_salary);
            return employee;
        }



    @Override
    public List<Employee> all() throws IOException {

        return null;
    }
}
