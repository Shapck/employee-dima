package pro.sky.employee.dima.employeedima.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employee.dima.employeedima.employee.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServicesImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServicesImpl departmentServices;

    @Test
    public void findMinSalary() {
        List<Employee> list = List.of(
                new Employee("sdsd","dsdsad",1,500),
                new Employee("sgfg","ddfgd",1,500464),
                new Employee("fdgd","dfgdf",46,5001521)
        );
        Mockito.when(employeeService.findAll()).thenReturn(list);

         Employee actual = departmentServices.findMinSalary(1);
        Assertions.assertEquals(new Employee("sdsd","dsdsad",1,500),actual);
    }

    @Test
    public void findMaxSalary() {
        List<Employee> list = List.of(
                new Employee("sdsd","dsdsad",1,500),
                new Employee("sgfg","ddfgd",1,500464),
                new Employee("fdgd","dfgdf",1,5001521)
        );
        Mockito.when(employeeService.findAll()).thenReturn(list);

        Employee actual = departmentServices.findMaxSalary(1);
        Assertions.assertEquals(new Employee("fdgd","dfgdf",1,5001521),actual);
    }

    @Test
    public void findAllByDepartment() {
        List<Employee> list = List.of(
                new Employee("sdsd","dsdsad",1,500),
                new Employee("sgfg","ddfgd",1,500464),
                new Employee("fdgd","dfgdf",1,5001521)
        );
        Mockito.when(employeeService.findAll()).thenReturn(list);

        List<Employee> actual = departmentServices.findAllByDepartment(1);
        Assertions.assertEquals(list,actual);
    }


}