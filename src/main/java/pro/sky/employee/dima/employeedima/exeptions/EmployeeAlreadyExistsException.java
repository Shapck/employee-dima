package pro.sky.employee.dima.employeedima.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Такой сотрудник уже есть")
public class EmployeeAlreadyExistsException extends RuntimeException{
}