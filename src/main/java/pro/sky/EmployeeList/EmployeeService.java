package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();
    private final int MAX_EMPLOYEE_QUANTITY = 5;

    public String addEmployee(String firstName, String lastName) {
        try {
            if (employees.size() >= MAX_EMPLOYEE_QUANTITY) {
                throw new EmployeeStorageIsFullException("Employee Storage Is Full");
            } else if (findByName(firstName,lastName) == null) {
                employees.add(new Employee(firstName, lastName));
                return "Employee added";
            } else {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            return e.getMessage();
        }
    }
    public String removeEmployee(String firstName, String lastName) {
        try {
            if (findByName(firstName,lastName) != null) {
                employees.remove(findByName(firstName,lastName));
                return "Employee removed";
            } else {
                throw new EmployeeNotFoundException();
            }
        } catch (EmployeeNotFoundException e) {
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
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException e) {
            return null;
        }
    }

}
