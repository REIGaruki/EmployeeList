package pro.sky.EmployeeList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path="/add")
    public String add(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.addEmployee(firstName,lastName);
    }
    @GetMapping(path="/remove")
    public String remove(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping(path="/add")
    public String find(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }

}
