package com.golf.app.repositories.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.golf.app.domain.Task;

public class TaskEmployeeMap {

	private TaskEmployeeMap(){};

	public static Map<String, List<String>> groupByEmployee(Map<String,Task> tasks) {
		Map<String, List<String>> taskByEmployee = new HashMap<String, List<String>>();

		for (Task task : tasks.values()) {
			boolean taskIdIsValid = null != task.getId() && !task.getId().isEmpty();

			if(taskIdIsValid) {
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

		}
		return taskByEmployee;
	}



}
