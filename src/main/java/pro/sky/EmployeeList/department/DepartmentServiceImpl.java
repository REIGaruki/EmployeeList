package pro.sky.EmployeeList.department;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeList.employee.Employee;
import pro.sky.EmployeeList.employee.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    EmployeeService employeeService = new EmployeeService(4);

    public Map<Integer, List<Employee>> printDepartments() {
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
        for (int i = 0; i < employeeService.getDepartmentQuantity(); i++) {
            employeeMap.put(i, printEmployeesInDepartment(i));
        }
        return employeeMap;
    }
    public List<Employee> printEmployeesInDepartment(Integer dept) {
        if (dept == null) {
            throw new NoDepartmentException("No department ID");
        } else if (dept >= employeeService.getDepartmentQuantity()) {
            throw new NoDepartmentException("No such department");
        } else {
            List<Employee> values = new ArrayList<>(employeeService.employees.values());
            List<Employee> employeesInDepartment = values.stream().filter(
                            (Employee value) -> value.getDepartment() == employeeService.getDept(dept))
                    .collect(Collectors.toList());
            return employeesInDepartment;
        }
    }
    public int printMaximalSalary(Integer dept) {
        if (dept == null) {
            throw new NoDepartmentException("No department ID");
        } else if (dept >= employeeService.getDepartmentQuantity()) {
            throw new NoDepartmentException("No such department");
        } else {
        List<Employee> values = new ArrayList<>(employeeService.employees.values());
        Employee employeWithMaxSalary = values.stream().filter(
                        (Employee value) -> value.getDepartment() == employeeService.getDept(dept))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException("No employees in department"));
        return employeWithMaxSalary.getSalary();
    }
        }
    public int printMinimalSalary(Integer dept) {
        if (dept == null) {
            throw new NoDepartmentException("No department ID");
        } else if (dept >= employeeService.getDepartmentQuantity()) {
            throw new NoDepartmentException("No such department");
        } else {
            List<Employee> values = new ArrayList<>(employeeService.employees.values());
            Employee employeWithMinSalary = values.stream().filter(
                            (Employee value) -> value.getDepartment() == employeeService.getDept(dept))
                    .min(Comparator.comparing(employee -> employee.getSalary()))
                    .orElseThrow(() -> new RuntimeException("No employees in department"));
            return employeWithMinSalary.getSalary();
        }
    }
    public int printDepartmentSalary(Integer dept) {
        if (dept == null) {
            throw new NoDepartmentException("No department ID");
        } else if (dept >= employeeService.getDepartmentQuantity()) {
            throw new NoDepartmentException("No such department");
        } else {
            List<Employee> values = new ArrayList<>(employeeService.employees.values());
            return values.stream().filter(
                            (Employee value) -> value.getDepartment() == employeeService.getDept(dept))
                    .mapToInt(Employee::getSalary)
                    .sum();
        }
    }
}