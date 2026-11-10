package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserAlreadyExistException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.dto.EmployeeDto;

@Service
public interface EmployeeService {

	Employee createEmployee(EmployeeDto dto) throws UserAlreadyExistException;
	
	List<Employee> getAllEmp();
	
	Employee getById(Integer id) throws UserNotFoundException;
	
	Employee updateEmployee(EmployeeDto dto) throws UserNotFoundException;
	
	String deleteEmp(Integer id);
	
	Employee getByName(String name) throws UserNotFoundException;
}
