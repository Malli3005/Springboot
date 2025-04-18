package com.example.first.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.entity.Employee;
import com.example.first.repository.EmployeeRepository;
import com.example.first.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getAllEMployees();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getById(@PathVariable("id") Long id) {
		return employeeService.getById(id);
		
	}
	@PutMapping("/{id}")
	public Optional<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id,employee);
	}
	 @DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return "employee deleted Successfully";
	}
	
	
	
	
	

}
