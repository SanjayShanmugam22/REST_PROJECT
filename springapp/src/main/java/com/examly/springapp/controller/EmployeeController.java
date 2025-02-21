package com.examly.springapp.controller;

import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ✅ Create Employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) 
    {
        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.OK);
    }
    @PostMapping("/bulk")
    public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = employeeService.createEmployees(employees);
        return ResponseEntity.status(201).body(savedEmployees);
    }
    
    // ✅ Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // ✅ Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Update Employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    // ✅ Delete Employee by ID
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
    boolean deleted = employeeService.deleteEmployee(id);
    if (deleted) {
        return ResponseEntity.ok("Employee deleted successfully!");
    } else {
        return ResponseEntity.notFound().build();
    }
}
// ✅ Delete All Employees
@DeleteMapping
public ResponseEntity<String> deleteAllEmployees() {
    employeeService.deleteAllEmployees();
    return ResponseEntity.ok("All employees deleted successfully!");
}


    // ✅ Get Employees with Pagination & Sorting
    @GetMapping("/page")
    public List<Employee> getEmployeesWithPaginationAndSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getEmployeesWithPaginationAndSorting(page, size, sortBy);
    }
}
