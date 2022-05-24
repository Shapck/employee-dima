package pro.sky.employee.dima.employeedima.service;

import pro.sky.employee.dima.employeedima.employee.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, int department, int salary);
    Employee deleteEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}