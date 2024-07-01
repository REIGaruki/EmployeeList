package pro.sky.EmployeeList.employee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeList.EmployeeListApplication;

import java.util.*;

@Service
public class EmployeeService{

    private final int MAX_EMPLOYEE_QUANTITY = 4;

    public List<Employee> printEmployees() {
        ArrayList<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        return values;
    }

    public List<Employee> addEmployee(String firstName, String lastName, Integer salary, Integer dept) {
        if (salary == null) {
            salary = 0;
        }
        if (dept == null) {
            dept = 0;
        }
        String key = StringUtils.lowerCase(firstName + lastName);
        if (EmployeeListApplication.employees.size() >= MAX_EMPLOYEE_QUANTITY) {
            throw new EmployeeStorageIsFullException("Employee Storage Is Full");
        } else if (EmployeeListApplication.employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        } else {
            EmployeeListApplication.employees.put(key,
                    new Employee(firstName, lastName, salary, EmployeeListApplication.departmentList.get(dept)));
            return new ArrayList<>(EmployeeListApplication.employees.values());
        }
    }
    public List<Employee> removeEmployee(String firstName, String lastName) {
        String key = StringUtils.lowerCase(firstName + lastName);
            if (EmployeeListApplication.employees.containsKey(key)) {
                EmployeeListApplication.employees.remove(key);
                return new ArrayList<>(EmployeeListApplication.employees.values());
            } else {
                throw new EmployeeNotFoundException();
            }
    }
    public Employee findEmployee(String firstName, String lastName) {
        String key = StringUtils.lowerCase(firstName + lastName);
        if (EmployeeListApplication.employees.containsKey(key)) {
            return EmployeeListApplication.employees.get(key);
        }
        throw new EmployeeNotFoundException();
    }


}
