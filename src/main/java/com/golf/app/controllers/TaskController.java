package com.golf.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.golf.app.domain.Task;
import com.golf.app.domain.TaskMutable;
import com.golf.app.repositories.EmployeeRepository;
import com.golf.app.repositories.TaskRepository;

@Controller
@RequestMapping("/task")
// cuando recibe peticiones que contengan "task" en la url, debe responder con
// este metodo
public class TaskController implements com.golf.app.controllers.Controller<TaskMutable> {

	private TaskRepository repository;
	private EmployeeRepository employeeRepository;;

	@Autowired
	public TaskController(TaskRepository repository, EmployeeRepository employeeRepository) {
		this.repository = repository;
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TaskMutable>> getAll() {

		List<Task> tasks = repository.readAll();

		List<TaskMutable> taskReponse = convertToApi(tasks);
		return ResponseEntity.status(HttpStatus.OK).body(taskReponse);

	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<TaskMutable> update(@RequestBody TaskMutable obj) {

		if (employeeRepository.read(obj.getPersonAssignedId()) != null) {
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

	private TaskMutable convertToApi(final Task task) {
		return task.mutable();
	}

	private List<TaskMutable> convertToApi(final List<Task> taskList) {
		return taskList.stream().map(t -> this.convertToApi(t)).collect(Collectors.toList());
	}
}
