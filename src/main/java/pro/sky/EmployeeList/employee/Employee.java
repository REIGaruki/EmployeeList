package pro.sky.EmployeeList.employee;

import org.apache.commons.lang3.StringUtils;
import pro.sky.EmployeeList.department.Department;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private Department department;

    public Employee(String firstName, String lastName, int salary, Department department) {
        setFirstName(firstName);
        setLastName(lastName);
        if (StringUtils.isAlpha(lastName)) {
            this.lastName = StringUtils.capitalize(lastName);
        } else {
            throw new UnallowedSymbolsExeption("LastName contains unallowed characters");
        }
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isAlpha(firstName)) {
            this.firstName = StringUtils.capitalize(firstName);
        } else {
            throw new UnallowedSymbolsExeption("FirstName contains unallowed characters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isAlpha(lastName)) {
            this.lastName = StringUtils.capitalize(lastName);
        } else {
            throw new UnallowedSymbolsExeption("LastName contains unallowed characters");
        }
    }

    @Override
    public String toString() {
        return  "Name: '" + firstName + ' ' + lastName + ", " +
                this.getDepartment() +
                ", Salary: " + salary + " hundred bucks" +
                '~';
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
