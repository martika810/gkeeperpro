package com.golf.app.repositories.collection;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

import com.golf.app.domain.Task;


public class TaskEmployeeMapTest {

	@Test
	public void testGroupByEmployee() {
		Map<String,Task> tasks = new HashMap<>();
		tasks.put("1",Task.of("1", "Task1", "Description task1", Arrays.asList("52", "53"), "1"));
		tasks.put("1 ",Task.of("1", "Task1", "Description task1", Arrays.asList("52", "53"), "1"));
		tasks.put("2",Task.of("2", "Task2", "Description task2", Arrays.asList("52", "53"), "1"));
		tasks.put("3",Task.of("3", "Task3", "Description task3", Arrays.asList("52"), "1"));
		tasks.put("",Task.of("", "Task3", "Description task3", Arrays.asList("52"), "1"));
		tasks.put(null,Task.of(null, "Task3", "Description task3", Arrays.asList("52"), "1"));

		Map<String, List<String>> taskGroupByEmployee = TaskEmployeeMap.groupByEmployee(tasks);
		assertEquals(2, taskGroupByEmployee.size());

		assertEquals(Arrays.asList("1", "2", "3"), taskGroupByEmployee.get("52"));
		assertEquals(Arrays.asList("1", "2"), taskGroupByEmployee.get("53"));

	}
}
