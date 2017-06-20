package com.golf.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golf.app.domain.Task;

@Component("TaskRepository")
public class TaskRepository implements Repository<String, Task> {

	private Map<String, Task> dataSource;

	public TaskRepository() {
		this.dataSource = new HashMap<>();
		init();
	}

	@Override
	public Task add(final Task obj) {
		dataSource.put(obj.getId(), obj);
		return dataSource.get(obj.getId());
	}

	@Override
	public Task update(final Task obj) {
		dataSource.put(obj.getId(), obj);
		return dataSource.get(obj.getId());
	}

	@Override
	public void update(List<Task> list) {
		for (Task task : list) {
			dataSource.put(task.getId(), task);
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

	@Override
	public List<Task> readAll() {
		return new ArrayList<>(dataSource.values());
	}

	private void init() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(Task.of("Task1", "Description task1"));
		tasks.add(Task.of("Task2", "Description task2"));
		tasks.add(Task.of("Task3", "Description task3"));
		update(tasks);
	}

}
