package pro.sky.EmployeeList;

import ch.qos.logback.core.joran.spi.ElementPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.EmployeeList.department.Department;
import pro.sky.EmployeeList.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class EmployeeListApplication {

	public static List<Department> departmentList = new ArrayList<>(List.of(
			new Department("Gym"),
			new Department("Dungeon")
	));
	public static Map<String, Employee> employees = new HashMap<>(Map.of(
			"VanDarkholme", new Employee("Van", "Darkholme", 3, departmentList.get(1)),
			"BillyHerrington", new Employee("Billy", "Herrington", 3, departmentList.get(0)),
			"DannyLee", new Employee("Danny", "Lee", 2, departmentList.get(0))
	));

	public static void main(String[] args) {
		SpringApplication.run(EmployeeListApplication.class, args);


	}

}
