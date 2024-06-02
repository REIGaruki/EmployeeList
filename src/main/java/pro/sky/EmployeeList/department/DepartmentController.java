package pro.sky.EmployeeList.department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.EmployeeList.employee.Employee;

import java.util.List;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path="/all")
    public List<Employee> printEmployeesInDepartment(@RequestParam(value="departmentId", required = false) Integer departmentId) {
        if (departmentId == null) {
            return departmentService.printDepartments();
        } else {
            return departmentService.printEmployeesInDepartment(departmentId);
        }
   }
    @GetMapping(path="/max-salary")
    public Employee printEmployeeWithMaximalSalary(@RequestParam(value="departmentId") int departmentId) {
        return departmentService.printEmployeeWithMaximalSalary(departmentId);
    }
    @GetMapping(path="/min-salary")
    public Employee printEmployeeWithMinimalSalary(@RequestParam(value="departmentId") int departmentId) {
        return departmentService.printEmployeeWithMinimalSalary(departmentId);
    }
}


