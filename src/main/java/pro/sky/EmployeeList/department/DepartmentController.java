package pro.sky.EmployeeList.department;

import org.springframework.web.bind.annotation.*;
import pro.sky.EmployeeList.employee.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path="/{id}/employees")
    public List<Employee> printEmployeesInDepartment(
            @PathVariable("id") int departmentId) {
        return departmentService.printEmployeesInDepartment(departmentId);
    }
    @GetMapping(path="/employees")
    public Map<Integer, List<Employee>> printEmployees() {
        return departmentService.printDepartments();
    }
    @GetMapping(path="/{id}/salary/max")
    public int printMaximalSalary(@PathVariable("id") int departmentId) {
        return departmentService.printMaximalSalary(departmentId);
    }
    @GetMapping(path="/{id}/salary/min")
    public int printMinimalSalary(@PathVariable("id") int departmentId) {
        return departmentService.printMinimalSalary(departmentId);
    }
    @GetMapping(path="/{id}/salary/sum")
    public int printDepartmentSalary(@PathVariable("id") int departmentId) {
        return departmentService.printDepartmentSalary(departmentId);
    }
}


