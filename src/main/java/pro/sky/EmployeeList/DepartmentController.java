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
    public String printEmployeesInDepartment(@RequestParam(value="departmentId", required = false) Integer departmentId) {
        if (departmentId == null) {
            return departmentService.printDepartments();
        } else {
            return departmentService.printEmployeesInDepartment(departmentId);
        }
   }
    @GetMapping(path="/max-salary")
    public String printEmployeeWithMaximalSalary(@RequestParam(value="departmentId") int departmentId) {
        return "Boss of the " + departmentService.departmentList.get(departmentId).getDeptName() +
                " is " + departmentService.printEmployeeWithMaximalSalary(departmentId);
    }
    @GetMapping(path="/min-salary")
    public String printEmployeeWithMinimalSalary(@RequestParam(value="departmentId") int departmentId) {
        return departmentService.printEmployeeWithMinimalSalary(departmentId) + "is a " + departmentId + "slave";
    }
}


