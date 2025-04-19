package com.example.first.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.entity.Employee;
import com.example.first.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public List<Employee> getAllEMployees(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }
	public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            existingEmployee.setFirst_name(updatedEmployee.getFirst_name());
            existingEmployee.setLast_name(updatedEmployee.getLast_name());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setPhone_number(updatedEmployee.getPhone_number());
            existingEmployee.setDepartments(updatedEmployee.getDepartments());
            existingEmployee.setDesignation(updatedEmployee.getDesignation());
            return employeeRepository.save(existingEmployee);
        });
    }

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
