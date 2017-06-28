package com.golf.app.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class Task implements Mutable<TaskMutable> {
	private final String id;
	private final String title;
	private final String description;
	private final List<String> personAssignedIds;
	private final List<String> toolAssignedIds;

	public static Task of(final String title, final String description) {
		return new Task(UUID.randomUUID().toString(), title, description, Collections.emptyList(), Collections.emptyList());
	}

	public static Task of(final String title, final String description, final List<String> employeeIds, final List<String> toolIds) {
		return new Task(UUID.randomUUID().toString(), title, description, employeeIds, toolIds);
	}

	public static Task of(final String id, final String title, final String description, final List<String> employeeIds, final List<String> toolIds) {
		return new Task(id, title, description, employeeIds, toolIds);

	}

	public TaskMutable mutable() {
		return new TaskMutable(this.getId(), this.getTitle(), this.getDescription(), this.getPersonAssignedIds(), this.getToolAssignedIds());
	}

	private Task(final String id, final String title, final String description, final List<String> personAssignedIds, final List<String> toolAssignedIds) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.personAssignedIds = new LinkedList<>(personAssignedIds);
		this.toolAssignedIds = new LinkedList<>(toolAssignedIds);
	}

	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}

	public List<String> getToolAssignedIds() {
		return new LinkedList<>(toolAssignedIds);
	}

	public List<String> getPersonAssignedIds() {
		return new LinkedList<>(personAssignedIds);
	}

	public Task withTitle(final String title) {
		return new Task(this.id, title, this.description, this.personAssignedIds, this.toolAssignedIds);
	}

	public Task withDescription(final String description) {
		return new Task(this.id, this.title, description, this.personAssignedIds, this.toolAssignedIds);
	}

	public Task withPersonAssigned(final String employeeId) {
		this.personAssignedIds.add(employeeId);
		return new Task(this.id, this.title, this.description, this.personAssignedIds, this.toolAssignedIds);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personAssignedIds == null) ? 0 : personAssignedIds.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toolAssignedIds == null) ? 0 : toolAssignedIds.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (personAssignedIds == null) {
			if (other.personAssignedIds != null)
				return false;
		} else if (!personAssignedIds.equals(other.personAssignedIds))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (toolAssignedIds == null) {
			if (other.toolAssignedIds != null)
				return false;
		} else if (!toolAssignedIds.equals(other.toolAssignedIds))
			return false;
		return true;
	}

}
