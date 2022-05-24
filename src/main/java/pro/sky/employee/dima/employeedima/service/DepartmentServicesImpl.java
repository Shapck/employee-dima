package pro.sky.employee.dima.employeedima.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.dima.employeedima.employee.Employee;
import pro.sky.employee.dima.employeedima.exeptions.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServicesImpl implements DepartmentServices {

    private  final EmployeeService employeeService;

    public DepartmentServicesImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMinSalary(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);


    }

    @Override
    public Employee findMaxSalary(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAllByDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllGroupByDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}