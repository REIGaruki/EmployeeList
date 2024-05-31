package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public List<Department> departmentList = new ArrayList<>(List.of(
            new Department("Gym"),
            new Department("Dungeon")
    ));
    public Map<String, Employee> employees = new HashMap<>(Map.of(
            "VanDarkholme", new Employee("Van", "Darkholme", 3, departmentList.get(1)),
            "BillyHerrington", new Employee("Billy", "Herrington", 3, departmentList.get(0)),
            "DannyLee", new Employee("Danny", "Lee", 2, departmentList.get(0))
    ));

    private final int MAX_EMPLOYEE_QUANTITY = 4;

    public List<Employee> printEmployees() {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        return values;
    }

    public String addEmployee(String firstName, String lastName, int salary, int dept) {
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
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName);
        }
        throw new EmployeeNotFoundException();
    }
    public List<Employee> printDepartments() {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        return values;
    }
    public List<Employee> printEmployeesInDepartment(Integer dept) {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        List<Employee> employeesInDepartment = values.stream().filter(
                (Employee value) -> value.getDepartment() == departmentList.get(dept))
                .collect(Collectors.toList());
        return employeesInDepartment;
    }
    public Employee printEmployeeWithMaximalSalary(int dept) {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        Employee max = values.stream().filter(
                (Employee value) -> value.getDepartment() == departmentList.get(dept))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException());
        return max;
    }
    public Employee printEmployeeWithMinimalSalary(int dept) {
        ArrayList<Employee> values = new ArrayList<>(employees.values());
        Employee min = values.stream().filter(
                (Employee value) -> value.getDepartment() == departmentList.get(dept))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException());
        return min;
    }

}
