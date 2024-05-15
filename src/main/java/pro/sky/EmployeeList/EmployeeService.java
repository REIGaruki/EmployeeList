package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<Employee>();
    private final int MAX_EMPLOYEE_QUANTITY = 5;

    public void addEmployee(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
    }
    public void removeEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equalsIgnoreCase(firstName) &&
                    employee.getLastName().equalsIgnoreCase(lastName)) {
                employees.remove(employee);
            }
        }
    }
    public String findEmployee(String firstName, String lastName) {
        try {
            for (Employee employee : employees) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) &&
                        employee.getLastName().equalsIgnoreCase(lastName)) {
                    return employee.toString();
                }
            }
            throw new EmployeeNotFoundException("No such employee exists");
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

}
