package com.example.demo.Impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Exception.UserAlreadyExistException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Service.EmployeeService;
import com.example.demo.dto.EmployeeDto;

@Service
public class EmployeeImpl implements EmployeeService {

	final EmployeeRepo employeeRepo;

	EmployeeImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee createEmployee(EmployeeDto dto) throws UserAlreadyExistException {
		Employee isUserExist = employeeRepo.findByEmail(dto.getEmail());
		if (Objects.isNull(isUserExist)) {
			Employee employee = new Employee();
			employee.setEmpName(dto.getEmpName());
			employee.setDepartment(dto.getDepartment());
			employee.setEmail(dto.getEmail());
			return employeeRepo.save(employee);
		}
		throw new UserAlreadyExistException("User already exist for give email : " + dto.getEmail());

	}

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getById(Integer id) throws UserNotFoundException {
		Employee employee = employeeRepo.findById(id).orElse(null);
		if (!Objects.isNull(employee)) {
			return employee;
		}
		throw new UserNotFoundException("User not found with this id :" + id);
	}

	@Override
	public Employee updateEmployee(EmployeeDto dto) throws UserNotFoundException {
		Employee existingEmployee = employeeRepo.findById(dto.getEmpId()).orElse(null);
		if (!Objects.isNull(existingEmployee)) {
			existingEmployee.setEmpName(dto.getEmpName());
			existingEmployee.setDepartment(dto.getDepartment());
			existingEmployee.setEmail(dto.getEmail());
			return employeeRepo.save(existingEmployee);
		}
		throw new UserNotFoundException("User not found with this id :" + dto.getEmpId());
	}

	@Override
	public String deleteEmp(Integer id) {
		Employee exist = employeeRepo.findById(id).orElse(null);
		if (!Objects.isNull(exist)) {
			employeeRepo.delete(exist);
			return "delete successfully";
		}
		return "employee not found";
	}

	@Override
	public Employee getByName(String name) throws UserNotFoundException {
		Employee getByName = employeeRepo.findByEmpName(name);
		if (!Objects.isNull(getByName)) {
			return getByName;
		}
		throw new UserNotFoundException("User not found with this name :" + name);
	}

}
