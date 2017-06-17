package com.golf.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.golf.app.domain.Employee;
import com.golf.app.domain.EmployeeMutable;
import com.golf.app.domain.Task;
import com.golf.app.domain.TaskMutable;
import com.golf.app.repositories.EmployeeRepository;
import com.golf.app.repositories.TaskRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController implements com.golf.app.controllers.Controller<EmployeeMutable> {
	
	private EmployeeRepository repository;
	
	@Autowired//cuando spring vaya a crear este objeto, va a buscar si tiene un objeto employeerepository, si no lo encuentra, falla.
	public EmployeeController(EmployeeRepository repository){
		
		this.repository = repository;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeMutable>> getAll() {
		List<Employee> employees = new ArrayList<>();
		employees.add(Employee.of("Juan","Ortega","Perez","imagen","Jardinero"));
		employees.add(Employee.of("Pedro","Ortega","Perez","imagen","Corta Arboles"));
		repository.update(employees);
		
		List<EmployeeMutable> employeeReponse =convertToApi(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employeeReponse);
	}

	@Override
	public ResponseEntity<EmployeeMutable> update(EmployeeMutable obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EmployeeMutable> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EmployeeMutable> create(EmployeeMutable obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private EmployeeMutable convertToApi(final Employee employee){
		return employee.mutable();
	}
	
	private List<EmployeeMutable> convertToApi(final List<Employee> employeeList){
		return employeeList.stream().map(t ->this.convertToApi(t)).collect(Collectors.toList());
	}
}
