package pro.sky.EmployeeList.employee;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.EmployeeList.department.Department;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService sut = new EmployeeService(4);
    private final List<Department> departmentList = new ArrayList<>(List.of(
            new Department("Gym"),
            new Department("Dungeon")
    ));
    private final Employee EMPLOYEE_1 = new Employee("Van", "Darkholme", 3, departmentList.get(1));
    private final Employee EMPLOYEE_2 = new Employee("Billy", "Herrington", 3, departmentList.get(0));
    private final Employee EMPLOYEE_3 = new Employee("Danny", "Lee", 2, departmentList.get(0));
    private final Employee EMPLOYEE_4 = new Employee("Mark", "Wolff", 0, departmentList.get(0));
    @Test
    void printEmployees() {
        Map<String, Employee> expected = new HashMap<>(Map.of(
                StringUtils.lowerCase(EMPLOYEE_1.getFirstName() + EMPLOYEE_1.getLastName()), EMPLOYEE_1,
                StringUtils.lowerCase(EMPLOYEE_2.getFirstName() + EMPLOYEE_2.getLastName()), EMPLOYEE_2,
                StringUtils.lowerCase(EMPLOYEE_3.getFirstName() + EMPLOYEE_3.getLastName()), EMPLOYEE_3
        ));
        Map<String, Employee> actual = sut.printEmployees();

    }

    @Test
    void addEmployee() {
        Map<String, Employee> expected = new HashMap<>(Map.of(
                StringUtils.lowerCase(EMPLOYEE_1.getFirstName() + EMPLOYEE_1.getLastName()), EMPLOYEE_1,
                StringUtils.lowerCase(EMPLOYEE_2.getFirstName() + EMPLOYEE_2.getLastName()), EMPLOYEE_2,
                StringUtils.lowerCase(EMPLOYEE_3.getFirstName() + EMPLOYEE_3.getLastName()), EMPLOYEE_3,
                StringUtils.lowerCase(EMPLOYEE_4.getFirstName() + EMPLOYEE_4.getLastName()), EMPLOYEE_4
        ));
        Map<String, Employee> actual = sut.addEmployee("Mark", "Wolff",null,null);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void addEmployeeThatAlreadyExist() {
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> sut.addEmployee(
                "Danny", "Lee",null,null));
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> sut.addEmployee(
                "danny", "LEE",0,1));
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> sut.addEmployee(
                "DaNnY", "leE",null,0));
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> sut.addEmployee(
                "dANNY", "lEE",2,null));
    }
    @Test
    void addEmployeeWithNoEmptySpace() {
        sut.setMaxEmployeeQuantity(3);
        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> sut.addEmployee(
                "Danny", "Lee",null,null));
    }
    @Test
    void addEmployeeWithUnallowedCharacters() {
        Assertions.assertThrows(UnallowedSymbolsExeption.class, () -> sut.addEmployee(
                "Danny&", "Lee?",null,null));
    }

    @Test
    void removeEmployee() {
        Map<String, Employee> expected = new HashMap<>(Map.of(
                StringUtils.lowerCase(EMPLOYEE_1.getFirstName() + EMPLOYEE_1.getLastName()), EMPLOYEE_1,
                StringUtils.lowerCase(EMPLOYEE_2.getFirstName() + EMPLOYEE_2.getLastName()), EMPLOYEE_2
        ));
        Map<String, Employee> actual = sut.removeEmployee("Danny", "Lee");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void findEmployee() {
        Employee expected = EMPLOYEE_1;
        Employee actual = sut.findEmployee("Van", "Darkholme");
        Assertions.assertEquals(expected,actual);
        actual = sut.findEmployee("van", "darkholme");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void removeEmployeeThatNotExist() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> sut.removeEmployee(
                "Mark", "Wolff"));
    }

    @Test
    void findEmployeeThatNotExist() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> sut.findEmployee(
                "Mark", "Wolff"));
    }

    @Test
    void setMaxEmployeeQuantity() {
        sut.setMaxEmployeeQuantity(5);
        int expected = 5;
        int actual = sut.getMaxEmployeeQuantity();
        Assertions.assertEquals(expected,actual);
        sut.setMaxEmployeeQuantity(4);
        expected = 4;
        actual = sut.getMaxEmployeeQuantity();
        Assertions.assertEquals(expected,actual);
        sut.setMaxEmployeeQuantity(3);
        expected = 3;
        actual = sut.getMaxEmployeeQuantity();
        Assertions.assertEquals(expected,actual);
        sut.setMaxEmployeeQuantity(2);
        expected = 3;
        actual = sut.getMaxEmployeeQuantity();
        Assertions.assertEquals(expected,actual);
    }
    @BeforeEach
    void printSUT() {
        System.out.println(sut.employees);
    }
}