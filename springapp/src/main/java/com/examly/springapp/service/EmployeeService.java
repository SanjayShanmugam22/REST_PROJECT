package com.examly.springapp.service;

import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ✅ Create Employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> createEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
    
    // ✅ Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Get Employee by ID (Fix the Optional<Employee> error)
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // ✅ Update Employee by ID
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setEmployeeName(updatedEmployee.getEmployeeName());
            employee.setDesignation(updatedEmployee.getDesignation());
            //employee.setTask(updatedEmployee.getTask());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    // ✅ Delete Employee by ID
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
    
    // ✅ Get Employees with Pagination & Sorting
    public List<Employee> getEmployeesWithPaginationAndSorting(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return employeeRepository.findAll(pageable).getContent();
    }
}
