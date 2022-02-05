package com.amirkenesbay.spring.rest.controller;

import com.amirkenesbay.spring.rest.entity.Department;
import com.amirkenesbay.spring.rest.entity.Employee;
import com.amirkenesbay.spring.rest.exception_handling.EmployeeIncorrectData;
import com.amirkenesbay.spring.rest.exception_handling.NoSuchDepartmentException;
import com.amirkenesbay.spring.rest.exception_handling.NoSuchEmployeeException;
import com.amirkenesbay.spring.rest.service.DepartmentService;
import com.amirkenesbay.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/departments")
    public List<Department> showAllDepartment(){
        List<Department> allDepartments = departmentService.getAllDepartments();
        return allDepartments;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        return employee;
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable int id){
        Department department = departmentService.getDepartment(id);
        if(department == null){
            throw new NoSuchDepartmentException("There is no department with ID = " + id + " in Database");
        }
        return department;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PostMapping("/departments")
    public Department addNewDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID: " + id + " was deleted";
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable int id){
        Department department = departmentService.getDepartment(id);
        if(department == null){
            throw new NoSuchDepartmentException("There is no department with ID = " + id + " in Database");
        }
        departmentService.deleteDepartment(id);
        return "Department with ID: " + id + " was deleted";
    }
}