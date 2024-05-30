package pro.sky.EmployeeList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {
    private final EmployeeService departmentService;
    public DepartmentController(EmployeeService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path="/all")
    public String printList() {
        return departmentService.printDepartments();
    }
    @GetMapping(path="/all")
    public String printDepartment(@RequestParam(value="departmentId") int departmentId) {
        return departmentService.printEmployeesInDepartment(departmentId);
    }
    @GetMapping(path="/max-salary")
    public String printEmployeeWithMaximalSalary(@RequestParam(value="departmentId") int departmentId) {
        return departmentService.printEmployeeWithMaximalSalary(departmentId);
    }
    @GetMapping(path="/min-salary")
    public String printEmployeeWithMinimalSalary(@RequestParam(value="departmentId") int departmentId) {
        return departmentService.printEmployeeWithMinimalSalary(departmentId);
    }
}


