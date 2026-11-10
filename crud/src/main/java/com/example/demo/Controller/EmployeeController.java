package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserAlreadyExistException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Service.EmployeeService;
import com.example.demo.dto.EmployeeDto;

@RestController
public class EmployeeController {

	final EmployeeService employeeService;
	
	EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@PostMapping("/Create")
	public Employee createEmployee(@RequestBody EmployeeDto dto) throws UserAlreadyExistException
	{
		return employeeService.createEmployee(dto);
	}
	
	@GetMapping("/fetch all")
	public List<Employee> getAllEmp()
	{
		return employeeService.getAllEmp();
	}
	
	@GetMapping("/getById/{id}")
	public Employee getById(@PathVariable Integer id) throws UserNotFoundException
	{
		return employeeService.getById(id);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody EmployeeDto dto) throws UserNotFoundException
	{
		return employeeService.updateEmployee(dto);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id)
	{
		return employeeService.deleteEmp(id);
	}
	
	@GetMapping("/getByName/{name}")
	public Employee getByName(@PathVariable String name) throws UserNotFoundException
	{
		return employeeService.getByName(name);
	}
}
