package com.example.demo.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Service.EmployeeService;
import com.example.demo.dto.EmployeeDto;

@Service
public class EmployeeImpl implements EmployeeService {

	
	final EmployeeRepo employeeRepo;
	
	EmployeeImpl(EmployeeRepo employeeRepo)
	{
		this.employeeRepo = employeeRepo;
	}
	
	@Override
	public Employee createEmployee(EmployeeDto dto) {
		Employee employee = new Employee();
		employee.setEmpName(dto.getEmpName());
		employee.setDepartment(dto.getDepartment());
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getById(Integer id) throws UserNotFoundException {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new UserNotFoundException("User not found with this id :" + id);
		}
	}

	@Override
	public Employee updateEmployee(EmployeeDto dto) {
		Optional<Employee> existingEmployee = employeeRepo.findById(dto.getEmpId());
		if(existingEmployee.isPresent())
		{
			Employee employee = existingEmployee.get();
			employee.setEmpName(dto.getEmpName());
			employee.setDepartment(dto.getDepartment());
			return employeeRepo.save(employee);
		}
		return null;
	}

	@Override
	public String deleteEmp(Integer id) {
		Optional<Employee> exist = employeeRepo.findById(id);
		if(exist.isPresent())
		{
			employeeRepo.delete(exist.get());
			return "delete successfully";
		}
		return "employee not found";
	}

	@Override
	public Employee getByName(String name) {
		Optional<Employee> getByName = employeeRepo.findByEmpName(name);
		if(getByName.isPresent())
		{
			return getByName.get();
		}
		return null;
	}

}
