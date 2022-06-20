package pro.sky.employee.dima.employeedima.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employee.dima.employeedima.employee.Employee;
import pro.sky.employee.dima.employeedima.exeptions.EmployeeAlreadyExistsException;
import pro.sky.employee.dima.employeedima.exeptions.EmployeeNotFoundException;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        if (StringUtils.isAllEmpty(firstName,lastName)
                || StringUtils.containsIgnoreCase(firstName,lastName)
                || StringUtils.length(firstName) < 2) {
            throw new EmployeeAlreadyExistsException();
        }

        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, department);
        if (this.employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyExistsException();
        }

        employeeMap.put(employee.getFullName(),employee);

        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(getKey(firstName,lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(getKey(firstName,lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeMap.values();
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

}