package pro.sky.EmployeeList.employee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeList.department.Department;

import java.util.*;

@Service
public class EmployeeService{
    public static List<Department> departmentList = new ArrayList<>(List.of(
            new Department("Gym"),
            new Department("Dungeon")
    ));
    public static Map<String, Employee> employees = new HashMap<>(Map.of(
            "vandarkholme", new Employee("Van", "Darkholme", 3, departmentList.get(1)),
            "billyherrington", new Employee("Billy", "Herrington", 3, departmentList.get(0)),
            "dannylee", new Employee("Danny", "Lee", 2, departmentList.get(0))
    ));

    private int maxEmployeeQuantity;

    public EmployeeService(int maxEmployeeQuantity) {
        this.maxEmployeeQuantity = maxEmployeeQuantity;
    }

    public void setMaxEmployeeQuantity(int maxEmployeeQuantity) {
        if (employees.size() <= maxEmployeeQuantity) {
            this.maxEmployeeQuantity = maxEmployeeQuantity;
        }
    }

    public int getMaxEmployeeQuantity() {
        return maxEmployeeQuantity;
    }

    public Map<String, Employee> printEmployees() {
        return employees;
    }

    public Map<String, Employee> addEmployee(String firstName, String lastName, Integer salary, Integer dept) {
        if (salary == null) {
            salary = 0;
        }
        if (dept == null) {
            dept = 0;
        }
        String key = StringUtils.lowerCase(firstName + lastName);
        if (employees.size() >= maxEmployeeQuantity) {
            throw new EmployeeStorageIsFullException("Employee Storage Is Full");
        } else if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        } else {
            employees.put(key,
                    new Employee(firstName, lastName, salary, departmentList.get(dept)));
            return employees;
        }
    }
    public Map<String, Employee> removeEmployee(String firstName, String lastName) {
        String key = StringUtils.lowerCase(firstName + lastName);
            if (employees.containsKey(key)) {
                employees.remove(key);
                return employees;
            } else {
                throw new EmployeeNotFoundException();
            }
    }
    public Employee findEmployee(String firstName, String lastName) {
        String key = StringUtils.lowerCase(firstName + lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException();
    }


}
