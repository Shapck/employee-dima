package pro.sky.employee.dima.employeedima.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.employee.dima.employeedima.employee.Employee;
import pro.sky.employee.dima.employeedima.exeptions.EmployeeAlreadyExistsException;
import pro.sky.employee.dima.employeedima.exeptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeService employeeService = new EmployeeServiceImpl();

    Employee employee = new Employee("Fil","Ivanov",2,30000);

    @Test
    public void addEmployee(){
        Employee employee1 = employeeService.addEmployee("Fil","Ivanov",2,30000);
        assertEquals(employee1,employee);
    }

    @Test
    public void addEmployeeIfNull() {
        assertThrows(EmployeeAlreadyExistsException.class,()->employeeService.addEmployee("","",2,30000));
    }

    @Test
    public void exceptionDeleteEmployee() {
        Employee employee1 = employeeService.addEmployee("Fil","Ivanov",2,30000);
        assertEquals(employee1,employee);
        assertThrows(EmployeeNotFoundException.class,()->employeeService.deleteEmployee("Ivan","Ivanov"));

    }

    @Test
    public void findEmployee() {
        Employee employee1 = employeeService.addEmployee("Fil","Ivanov",2,30000);
        assertEquals(employee1,employee);
        Employee employee2 = employeeService.findEmployee("Fil","Ivanov");
        assertEquals(employee2,employee);
    }

    @Test
    public void DeleteEmployee() {
        Employee employee1 = employeeService.addEmployee("Fil","Ivanov",2,30000);
        assertEquals(employee1,employee);
        employeeService.deleteEmployee("Fil","Ivanov");
        assertThrows(EmployeeNotFoundException.class,()->employeeService.findEmployee("Fil","Ivanov"));
    }



}