package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Van", "Darkholme"),
            new Employee("Billy", "Herrington"),
            new Employee("Danny", "Lee")
    ));

    private final int MAX_EMPLOYEE_QUANTITY = 4;

    public String addEmployee(String firstName, String lastName) {
            if (employees.size() >= MAX_EMPLOYEE_QUANTITY) {
                throw new EmployeeStorageIsFullException("Employee Storage Is Full");
            } else if (findByName(firstName,lastName) != null) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            } else {
                employees.add(new Employee(firstName, lastName));
                return "Employee added";
            }
    }
    public String removeEmployee(String firstName, String lastName) {
            if (findByName(firstName,lastName) != null) {
                employees.remove(findByName(firstName,lastName));
                return "Employee removed";
            }
            throw new EmployeeNotFoundException();
    }
    public String findEmployee(String firstName, String lastName) {
        if (findByName(firstName, lastName) != null) {
            return findByName(firstName, lastName).toString();
        }
        throw new EmployeeNotFoundException();
    }
    public Employee findByName(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equalsIgnoreCase(firstName) &&
                    employee.getLastName().equalsIgnoreCase(lastName)) {
                return employee;
            }
        }
        return null;
    }

}
