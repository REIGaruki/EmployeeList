package pro.sky.EmployeeList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.EmployeeList.department.Department;
import pro.sky.EmployeeList.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class EmployeeListApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeListApplication.class, args);


	}

}
