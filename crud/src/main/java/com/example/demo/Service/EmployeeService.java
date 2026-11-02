package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.dto.EmployeeDto;

@Service
public interface EmployeeService {

	Employee createEmployee(EmployeeDto dto);
	
	List<Employee> getAllEmp();
	
	Employee getById(Integer id);
	
	Employee updateEmployee(EmployeeDto dto);
	
	String deleteEmp(Integer id);
}
