package pro.sky.EmployeeList.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
        System.out.println(this);
    }
}
