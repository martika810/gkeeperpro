package com.golf.app.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.golf.app.repositories.collection.TaskEmployeeMap;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.golf.app.domain.Task;

@Profile("stubbed")
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

	public Map<String,List<String>> readGroupByEmployee(){
		Map<String,Task> taskMap = readAll();
		return TaskEmployeeMap.groupByEmployee(taskMap);
	}

	@Override
	public void delete(String key) {
		dataSource.remove(dataSource.get(key));

	}

	@Override
	public Map<String, Task> readAll() {
		return new HashMap<>(dataSource);
	}

	private void init() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(Task.of("1", "Task1", "Description task1", Arrays.asList("52", "53"), "1"));
		tasks.add(Task.of("2", "Task2", "Description task2", Arrays.asList("52", "53"), "1"));
		tasks.add(Task.of("3", "Task3", "Description task3", Arrays.asList("52", "53"), "1"));
		update(tasks);
	}
}
