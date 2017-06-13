package com.golf.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.golf.app.domain.Task;
import com.golf.app.domain.TaskMutable;
import com.golf.app.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/task")
public class TaskController implements com.golf.app.controllers.Controller<TaskMutable>{
	
	private TaskRepository repository;
	
	@Autowired
	public TaskController(TaskRepository repository){
		this.repository = repository;
	}
   
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TaskMutable>> getAll(){
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(Task.of("Task1","Description task1"));
		tasks.add(Task.of("Task2","Description task2"));
		tasks.add(Task.of("Task3","Description task3"));
		repository.update(tasks);
		
		List<TaskMutable> taskReponse =convertToApi(tasks);
        return ResponseEntity.status(HttpStatus.OK).body(taskReponse);
        
    }


	@RequestMapping(consumes = "application/json",method = RequestMethod.PUT)
	public ResponseEntity<TaskMutable> update(@RequestBody TaskMutable obj){
		repository.update(obj.inmutable());
		return ResponseEntity.status(HttpStatus.OK).body(repository.read(obj.getId()).mutable());
	}
	
	
	@RequestMapping(value="/{taskId}" , method = RequestMethod.DELETE)
	public ResponseEntity<TaskMutable> delete(@PathVariable String taskId){
		 repository.delete(taskId);
		 return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@RequestMapping(consumes = "application/json" , method = RequestMethod.POST)
	public ResponseEntity<TaskMutable> create(@RequestBody TaskMutable obj) {
		repository.add(obj.inmutable());
		return ResponseEntity.status(HttpStatus.OK).body(repository.read(obj.getId()).mutable());
	}
	
	private TaskMutable convertToApi(final Task task){
		return task.mutable();
	}
	
	private List<TaskMutable> convertToApi(final List<Task> taskList){
		return taskList.stream().map(t ->this.convertToApi(t)).collect(Collectors.toList());
	}
}
