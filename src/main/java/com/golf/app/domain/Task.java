package com.golf.app.domain;

import java.util.UUID;

public final class Task implements Mutable<TaskMutable> {
	private final String id;
	private final String title;
	private final String description;
	private final String personAssignedId;

	public static Task of(final String title, final String description) {
		return new Task(UUID.randomUUID().toString(), title, description, Employee.EMPTY);
	}

	public static Task of(final String title, final String description, final String employeeId) {
		return new Task(UUID.randomUUID().toString(), title, description, employeeId);
	}

	public static Task of(final String id, final String title, final String description, final String employeeId) {
		return new Task(id, title, description, employeeId);
	}

	public TaskMutable mutable() {
		return new TaskMutable(this.getId(), this.getTitle(), this.getDescription(), this.getPersonAssignedId());
	}

	private Task(final String id, final String title, final String description, final String personAssignedId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.personAssignedId = personAssignedId;
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
	public String getPersonAssignedId() {
		return personAssignedId;
	}

	public Task withTitle(final String title) {
		return new Task(this.id, title, this.description, this.personAssignedId);
	}

	public Task withDescription(final String description) {
		return new Task(this.id, this.title, description, this.personAssignedId);
	}

	public Task withPersonAssigned(final String employeeId) {
		return new Task(this.id, this.title, this.description, employeeId);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Task task = (Task) o;

		if (!id.equals(task.id))
			return false;
		if (!title.equals(task.title))
			return false;
		if (description != null ? !description.equals(task.description) : task.description != null)
			return false;
		return personAssignedId.equals(task.personAssignedId);

	}

	@Override
	// mejora la eficiencia de los maps
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + personAssignedId.hashCode();
		return result;
	}
}
