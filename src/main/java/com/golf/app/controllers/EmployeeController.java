package com.golf.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.golf.app.domain.Mutable;
import com.golf.app.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.golf.app.domain.Employee;
import com.golf.app.domain.EmployeeMutable;
import com.golf.app.repositories.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController implements com.golf.app.controllers.Controller<EmployeeMutable> {

	private EmployeeRepository repository;

	@Autowired
	// cuando spring vaya a crear este objeto, va a buscar si tiene un objeto
	// employeerepository, si no lo encuentra, falla.
	public EmployeeController(EmployeeRepository repository) {

		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, EmployeeMutable>> getAll() {

		Map<String, Employee> employees = repository.readAll();
		Map<String, EmployeeMutable> employeeReponse = convertToApi(employees);
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

	private Map<String, EmployeeMutable> convertToApi(final Map<String, Employee> map) {
		Map<String, EmployeeMutable> mutableMap = new HashMap<>();
		map.keySet().stream().forEach(key -> {
			EmployeeMutable taskMutable = map.get(key).mutable();
			mutableMap.put(key, taskMutable);

		});
		return mutableMap;
	}
}
