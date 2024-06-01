package pro.sky.EmployeeList;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService{

    public List<Employee> printDepartments() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < EmployeeListApplication.departmentList.size(); i++) {
            employeeList.addAll(printEmployeesInDepartment(i));
        }
        return employeeList;
    }
    public List<Employee> printEmployeesInDepartment(Integer dept) {
        ArrayList<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        List<Employee> employeesInDepartment = values.stream().filter(
                        (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .collect(Collectors.toList());
        return employeesInDepartment;
    }
    public Employee printEmployeeWithMaximalSalary(int dept) {
        ArrayList<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        return values.stream().filter(
                        (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException());
    }
    public Employee printEmployeeWithMinimalSalary(int dept) {
        ArrayList<Employee> values = new ArrayList<>(EmployeeListApplication.employees.values());
        return values.stream().filter(
                        (Employee value) -> value.getDepartment() == EmployeeListApplication.departmentList.get(dept))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new RuntimeException());
    }

}