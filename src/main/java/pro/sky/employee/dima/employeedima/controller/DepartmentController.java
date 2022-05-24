package pro.sky.employee.dima.employeedima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.dima.employeedima.employee.Employee;
import pro.sky.employee.dima.employeedima.service.DepartmentServices;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalary(@RequestParam int department){
        return departmentServices.findMaxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalary(@RequestParam int department){
        return departmentServices.findMinSalary(department);
    }

    @GetMapping(path = "/all-department")
    public List<Employee> findAllByDepartment(@RequestParam int department){
        return departmentServices.findAllByDepartment(department);
    }

    @GetMapping(path = "/max-salary")
    public Map<Integer,List<Employee>>findMinSalary(@RequestParam Integer department){
        return departmentServices.findAllGroupByDepartment();
    }


}