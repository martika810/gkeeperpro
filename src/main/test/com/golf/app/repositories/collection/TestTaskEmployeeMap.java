package com.golf.app.repositories.collection;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.golf.app.domain.Task;

public class TestTaskEmployeeMap {

	@Test
	public void testGroupByEmployee() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(Task.of("1", "Task1", "Description task1", Arrays.asList("52", "53"), "1"));
		tasks.add(Task.of("1", "Task1", "Description task1", Arrays.asList("52", "53"), "1"));
		tasks.add(Task.of("2", "Task2", "Description task2", Arrays.asList("52", "53"), "1"));
		tasks.add(Task.of("3", "Task3", "Description task3", Arrays.asList("52"), "1"));

		Map<String, List<String>> taskGroupByEmployee = TaskEmployeeMap.groupByEmployee(tasks);
		assertEquals(2, taskGroupByEmployee.size());

		assertEquals(Arrays.asList("1", "2", "3"), taskGroupByEmployee.get("52"));
		assertEquals(Arrays.asList("1", "2"), taskGroupByEmployee.get("53"));

	}
}
