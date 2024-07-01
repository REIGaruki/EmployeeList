package pro.sky.EmployeeList.department;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeList.employee.Employee;
import pro.sky.EmployeeList.EmployeeListApplication;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    public Map<Integer, List<Employee>> printDepartments() {
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
        for (int i = 0; i < EmployeeListApplication.departmentList.size(); i++) {
            employeeMap.put(i, printEmployeesInDepartment(i));
        }
        return employeeMap;
    }
    public List<Employee> printEmployeesInDepartment(Integer dept) {
        List<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        List<Employee> employeesInDepartment = values.stream().filter(
                        (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .collect(Collectors.toList());
        return employeesInDepartment;
    }
    public int printMaximalSalary(int dept) {
        List<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        Employee employeWithMaxSalary = values.stream().filter(
                        (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException());
        return employeWithMaxSalary.getSalary();
    }
    public int printMinimalSalary(int dept) {
        List<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        Employee employeWithMinSalary = values.stream().filter(
                        (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException());
        return employeWithMinSalary.getSalary();
    }
    public int printDepartmentSalary(int dept) {
        List<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        return values.stream().filter(
                (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .mapToInt(Employee::getSalary)
                .sum();
    }

}