package pro.sky.EmployeeList;

import java.util.Objects;

public class Department {
    private final String deptName;
    public Department(String deptName) {
        this.deptName = deptName;
    }
    public String getDeptName() {
        return this.deptName;
    }
    @Override
    public String toString() {
        return "Department: " + deptName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(deptName, that.deptName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(deptName);
    }
}
