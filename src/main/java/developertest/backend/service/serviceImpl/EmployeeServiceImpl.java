package developertest.backend.service.serviceImpl;


import developertest.backend.exception.EmployeeNotFoundException;
import developertest.backend.model.entities.Employee;
import developertest.backend.service.EmployeeService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
            System.out.println("An error has occurred");
        }
        return result.toString();
    }

    public String connectApiUrl2() throws IOException
    {
        StringBuilder result = new StringBuilder();
        URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
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
            System.out.println("An error has occurred");
        }
        return result.toString();
    }


    @Override
    public Employee findById(String id) throws EmployeeNotFoundException,IOException
        {
            String ans=connectApi(id);
            JSONObject jsonObj = new JSONObject(ans);
            JSONObject res = jsonObj.getJSONObject("data");

            Employee employee= new Employee(res);
            return employee;
        }



    @Override
    public List<Employee> all() throws IOException {
        List<Employee> employees=new ArrayList<>();
        String ans=connectApiUrl2();
        JSONObject jsonObj = new JSONObject(ans);

        JSONArray res = jsonObj.getJSONArray("data");
        for(int i=0;i< res.length();i++)
        {
            JSONObject e=res.getJSONObject(i);
            Employee employee=new Employee(e);
            employees.add(employee);
        }
        return employees;
    }
}
