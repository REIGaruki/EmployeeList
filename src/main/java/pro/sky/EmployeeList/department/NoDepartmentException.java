package pro.sky.EmployeeList.department;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDepartmentException extends RuntimeException{
    public NoDepartmentException(String message) {
        super(message);
        System.out.println(this);
    }
}
