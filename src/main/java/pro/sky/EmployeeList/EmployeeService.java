package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<Employee>();
    private final int MAX_EMPLOYEE_QUANTITY = 5;

    public String addEmployee(String firstName, String lastName) {
        try {
            if (employees.size() >= MAX_EMPLOYEE_QUANTITY) {
                throw new EmployeeStorageIsFullException("Employee Storage Is Full");
            } else {
                employees.add(new Employee(firstName, lastName));
                return "Employee added";
            }
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }
    public String removeEmployee(String firstName, String lastName) {
        try {
            Employee employee = findByName(firstName, lastName);
            employees.remove(employee);
            return "Employee removed";
        } catch (NullPointerException e) {
            return "Can't remove, employee does not exist";
        }
    }
    public String findEmployee(String firstName, String lastName) {
        try {
            return findByName(firstName, lastName).toString();
        } catch(NullPointerException e) {
            return "Employee is not found";
        }
    }
    public Employee findByName(String firstName, String lastName) {
        try {
            for (Employee employee : employees) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) &&
                        employee.getLastName().equalsIgnoreCase(lastName)) {
                    return employee;
                }
            }
            throw new EmployeeNotFoundException("No such employee exists");
        } catch (EmployeeNotFoundException e) {
            return null;
        }
    }

}
