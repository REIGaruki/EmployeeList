package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    public List<Department> departmentList = new ArrayList<>(List.of(
            new Department("Gym"),
            new Department("Dungeon")
    ));
    public Map<String, Employee> employees = new HashMap<>(Map.of(
            "VanDarkholme", new Employee("Van", "Darkholme", 300, departmentList.get(1)),
            "BillyHerrington", new Employee("Billy", "Herrington", 250, departmentList.get(0)),
            "DannyLee", new Employee("Danny", "Lee", 255, departmentList.get(0))
    ));

    private final int MAX_EMPLOYEE_QUANTITY = 4;

    public String printEmployees() {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        return values.toString();
    }

    public String addEmployee(String firstName, String lastName, double salary, int dept) {
            if (employees.size() >= MAX_EMPLOYEE_QUANTITY) {
                throw new EmployeeStorageIsFullException("Employee Storage Is Full");
            } else if (employees.containsKey(firstName + lastName)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            } else {
                employees.put(firstName + lastName, new Employee(firstName, lastName, salary, departmentList.get(dept)));
                return "Employee added";
            }
    }
    public String removeEmployee(String firstName, String lastName) {
            if (employees.containsKey(firstName + lastName)) {
                employees.remove(firstName + lastName);
                return "Employee removed";
            } else {
                throw new EmployeeNotFoundException();
            }
    }
    public String findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName).toString();
        }
        throw new EmployeeNotFoundException();
    }
    public String printDepartments() {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        return values.toString();
    }

}
