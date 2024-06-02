package pro.sky.EmployeeList.employee;

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
        if (EmployeeListApplication.employees.size() >= MAX_EMPLOYEE_QUANTITY) {
            throw new EmployeeStorageIsFullException("Employee Storage Is Full");
        } else if (EmployeeListApplication.employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        } else {
            EmployeeListApplication.employees.put(firstName + lastName,
                    new Employee(firstName, lastName, salary, EmployeeListApplication.departmentList.get(dept)));
            return new ArrayList<>(EmployeeListApplication.employees.values());
        }
    }
    public List<Employee> removeEmployee(String firstName, String lastName) {
            if (EmployeeListApplication.employees.containsKey(firstName + lastName)) {
                EmployeeListApplication.employees.remove(firstName + lastName);
                return new ArrayList<>(EmployeeListApplication.employees.values());
            } else {
                throw new EmployeeNotFoundException();
            }
    }
    public Employee findEmployee(String firstName, String lastName) {
        if (EmployeeListApplication.employees.containsKey(firstName + lastName)) {
            return EmployeeListApplication.employees.get(firstName + lastName);
        }
        throw new EmployeeNotFoundException();
    }


}
