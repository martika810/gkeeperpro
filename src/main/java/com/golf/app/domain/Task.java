package com.golf.app.domain;

import java.util.UUID;

public final class Task implements Mutable<TaskMutable> {
	private final String id;
	private final String title;
	private final String description;
	private final String personAssignedId;
	private final String toolAssignedId;

	public static Task of(final String title, final String description) {
		return new Task(UUID.randomUUID().toString(), title, description, Employee.EMPTY, Tool.EMPTY);
	}

	public static Task of(final String title, final String description, final String employeeId, final String toolId) {
		return new Task(UUID.randomUUID().toString(), title, description, employeeId, toolId);
	}

	public static Task of(final String id, final String title, final String description, final String employeeId, final String toolId) {
		return new Task(id, title, description, employeeId, toolId);

	}

	public TaskMutable mutable() {
		return new TaskMutable(this.getId(), this.getTitle(), this.getDescription(), this.getPersonAssignedId(), this.getToolAssignedId());
	}

	private Task(final String id, final String title, final String description, final String personAssignedId, final String toolAssignedId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.personAssignedId = personAssignedId;
		this.toolAssignedId = toolAssignedId;
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

	public String getToolAssignedId() {
		return toolAssignedId;
	}

	public String getPersonAssignedId() {
		return personAssignedId;
	}

	public Task withTitle(final String title) {
		return new Task(this.id, title, this.description, this.personAssignedId, this.toolAssignedId);
	}

	public Task withDescription(final String description) {
		return new Task(this.id, this.title, description, this.personAssignedId, this.toolAssignedId);
	}

	public Task withPersonAssigned(final String employeeId) {
		return new Task(this.id, this.title, this.description, employeeId, this.toolAssignedId);
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
		if (personAssignedId == null) {
			if (other.personAssignedId != null)
				return false;
		} else if (!personAssignedId.equals(other.personAssignedId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (toolAssignedId == null) {
			if (other.toolAssignedId != null)
				return false;
		} else if (!toolAssignedId.equals(other.toolAssignedId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personAssignedId == null) ? 0 : personAssignedId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toolAssignedId == null) ? 0 : toolAssignedId.hashCode());
		return result;
	}
}
