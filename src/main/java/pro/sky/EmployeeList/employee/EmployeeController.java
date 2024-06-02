package pro.sky.EmployeeList.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> printList() {
        return employeeService.printEmployees();
    }
    @GetMapping(path="/add")
    public List<Employee> add(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "salary", required = false) Integer salary,
            @RequestParam(value = "dept", required = false) Integer dept
            ) {
        return employeeService.addEmployee(firstName,lastName, salary, dept);
    }
    @GetMapping(path="/remove")
    public List<Employee> remove(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping(path="/find")
    public Employee find(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }

}
