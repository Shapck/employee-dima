package pro.sky.employee.dima.employeedima.service;

import pro.sky.employee.dima.employeedima.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServices {
    Employee findMinSalary(int department);
    Employee findMaxSalary(int department);
    List<Employee> findAllByDepartment(int department);

    Map<Integer, List<Employee>> findAllGroupByDepartment();
}