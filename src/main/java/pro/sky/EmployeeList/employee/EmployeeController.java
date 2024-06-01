package pro.sky.EmployeeList.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public String printList() {
        return employeeService.printEmployees().toString();
    }
    @GetMapping(path="/add")
    public String add(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "salary", required = false) Integer salary,
            @RequestParam(value = "dept", required = false) Integer dept
            ) {
        return employeeService.addEmployee(firstName,lastName, salary, dept);
    }
    @GetMapping(path="/remove")
    public String remove(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping(path="/find")
    public String find(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(firstName,lastName).toString();
    }

}
