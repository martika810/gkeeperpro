package com.golf.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.golf.app.domain.Mutable;
import com.golf.app.domain.Task;
import com.golf.app.domain.TaskMutable;
import com.golf.app.repositories.EmployeeRepository;
import com.golf.app.repositories.TaskRepository;
import com.golf.app.repositories.ToolRepository;

@Controller
@RequestMapping("/task")
// cuando recibe peticiones que contengan "task" en la url, debe responder con
// este metodo
public class TaskController implements com.golf.app.controllers.Controller<TaskMutable> {

	private TaskRepository repository;
	private EmployeeRepository employeeRepository;;
	private ToolRepository toolRepository;;

	@Autowired
	public TaskController(TaskRepository repository, EmployeeRepository employeeRepository, ToolRepository toolRepository) {
		this.repository = repository;
		this.employeeRepository = employeeRepository;
		this.toolRepository = toolRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, TaskMutable>> getAll() {

		Map<String,Task> tasks = repository.readAll();


		Map<String, TaskMutable> taskResponse = convertToApi(tasks);
		return ResponseEntity.status(HttpStatus.OK).body(taskResponse);

	}

	@RequestMapping(path = "/by_employee", method = RequestMethod.GET)
	public ResponseEntity<Map<String,List<String>>> getTasksGroupByEmployee(){
		Map<String,List<String>> taskGroupByEmployee = repository.readGroupByEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(taskGroupByEmployee);
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<TaskMutable> update(@RequestBody TaskMutable obj) {
		boolean employeeIsValid = validEmployees(obj.getPersonAssignedIds());
		boolean toolIsValid = validTools(obj.getToolAssignedIds()) ;
		boolean taskIsValid = employeeIsValid  &&  toolIsValid;
		if (taskIsValid) {
			repository.update(obj.inmutable());
			return ResponseEntity.status(HttpStatus.OK).body(repository.read(obj.getId()).mutable());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).header("error", "Employee not found").body(null);
		}

	}

	@RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
	public ResponseEntity<TaskMutable> delete(@PathVariable String taskId) {
		repository.delete(taskId);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<TaskMutable> create(@RequestBody TaskMutable obj) {
		repository.add(obj.inmutable());
		return ResponseEntity.status(HttpStatus.OK).body(repository.read(obj.getId()).mutable());
	}

	private boolean validEmployees(List<String> employeeIds) {
		boolean valid = true;
		for (String employeeId : employeeIds) {
			if (employeeRepository.read(employeeId) == null) {
				return false;
			}
		}
		return valid;

	}
	private boolean validTools(List<String> toolIds) {
		boolean valid = true;
		for (String toolId : toolIds) {
			if (toolRepository.read(toolId) == null) {
				return false;
			}
		}
		return valid;

	}

	private Map<String, TaskMutable> convertToApi(final Map<String, Task> map) {
		Map<String, TaskMutable> mutableMap = new HashMap<>();
		map.keySet().stream().forEach(key -> {
			TaskMutable taskMutable = map.get(key).mutable();
			mutableMap.put(key, taskMutable);

		});
		return mutableMap;
	}
}
