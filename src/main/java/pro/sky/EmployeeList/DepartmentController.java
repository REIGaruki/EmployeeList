package pro.sky.EmployeeList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class DepartmentController {
    @RestController
    @RequestMapping(path="/department")
    public class EmployeeController {
        private final DepartmentService departmentService;

        public EmployeeController(DepartmentService departmentService) {
            this.departmentService = departmentService;
        }
    }
}
