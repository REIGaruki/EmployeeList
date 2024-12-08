package pro.sky.EmployeeList.department;

import pro.sky.EmployeeList.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> printDepartments();
    List<Employee> printEmployeesInDepartment(Integer dept);
    int printMaximalSalary(Integer dept);
    int printMinimalSalary(Integer dept);
    int printDepartmentSalary(Integer dept);
}
