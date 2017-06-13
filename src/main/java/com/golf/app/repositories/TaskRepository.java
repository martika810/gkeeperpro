package com.golf.app.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golf.app.domain.Task;

@Component("TaskRepository")
public class TaskRepository implements Repository<String,Task> {
	
	private Map<String,Task> dataSource;
	
	public TaskRepository(){
		this.dataSource = new HashMap<>();
	}

	@Override
	public Task add(final Task obj) {
		dataSource.put(obj.id(), obj);
		return dataSource.get(obj.id());
	}

	@Override
	public Task update(final Task obj) {
		dataSource.put(obj.id(), obj);
		return dataSource.get(obj.id());
	}

	@Override
	public void update(List<Task> list) {
		for(Task task:list ){
			dataSource.put(task.id(), task);			
		}
		
	}

	@Override
	public Task read(String key) {
		return dataSource.get(key);
	}

	@Override
	public void delete(String key) {
		dataSource.remove(dataSource.get(key));
		
	}

}
