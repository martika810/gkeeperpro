package com.golf.app.repositories.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.golf.app.domain.Task;

public class TaskEmployeeMap {

	private final Map<String, List<String>> taskByEmployee = new HashMap<String, List<String>>();

	static Map<String, List<String>> groupByEmployee(List<Task> tasks) {
		Map<String, List<String>> taskByEmployee = new HashMap<String, List<String>>();

		for (Task task : tasks) {
			List<String> employeeAssignedToCurrentTask = task.getPersonAssignedIds();
			for (String employeeId : employeeAssignedToCurrentTask) {
				if (taskByEmployee.get(employeeId) == null) {
					List<String> firstTask = new ArrayList<>();
					firstTask.add(task.getId());
					taskByEmployee.put(employeeId, firstTask);
				} else {
					if (!taskByEmployee.get(employeeId).contains(task.getId())) {
						taskByEmployee.get(employeeId).add(task.getId());
					}
				}
			}

		}
		return taskByEmployee;
	}

}
