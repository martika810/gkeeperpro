package com.golf.app.controllers;

import java.util.ArrayList;
import java.util.List;

import com.golf.app.domain.Task;
import com.golf.app.domain.api.TaskMutable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/task")
public class TaskController {
   
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TaskMutable>> get(){
		
		List<TaskMutable> tasks = new ArrayList<>();
		tasks.add(Task.of("Task1").toMutable());
		tasks.add(Task.of("Task2").toMutable());
		tasks.add(Task.of("Task3").toMutable());
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
        
    }
}
