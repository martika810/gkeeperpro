package com.golf.app.domain;


public class TaskMutable {
	private String id;
	private String title;
	private String description;
	private String personAssignedId;

	public TaskMutable() {
	}

	public TaskMutable(String id, String title, String description, String personAssignedId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.personAssignedId = personAssignedId;
	}

	public Task inmutable() {
		return Task.of(this.getId(), this.getTitle(), this.getDescription(), this.getPersonAssignedId());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPersonAssignedId() {
		return personAssignedId;
	}

	public void setPersonAssignedId(String personAssignedId) {
		this.personAssignedId = personAssignedId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TaskMutable that = (TaskMutable) o;

		if (!id.equals(that.id))
			return false;
		if (!title.equals(that.title))
			return false;
		if (description != null ? !description.equals(that.description) : that.description != null)
			return false;
		return personAssignedId.equals(that.personAssignedId);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + personAssignedId.hashCode();
		return result;
	}
}
