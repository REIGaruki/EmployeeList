package pro.sky.EmployeeList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/department")
public class DepartmentController {
    private final EmployeeService departmentService;
    public DepartmentController(EmployeeService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping()
    public String printList() {
        return departmentService.printDepartments();
    }
}


