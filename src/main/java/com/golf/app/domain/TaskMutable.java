package com.golf.app.domain;


public class TaskMutable {
	private String id;
	private String title;
	private String description;
	private String personAssignedId;
	private String toolAssignedId;
	
	public TaskMutable() {
	}

	public TaskMutable(String id, String title, String description, String personAssignedId,String toolAssignedId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.personAssignedId = personAssignedId;
		this.toolAssignedId= toolAssignedId;
	}

	public Task inmutable() {
		return Task.of(this.getId(), this.getTitle(), this.getDescription(), this.getPersonAssignedId(),this.getToolAssignedId());
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
	
	public String getToolAssignedId() {
		return toolAssignedId;
	}

	public void setPersonAssignedId(String personAssignedId) {
		this.personAssignedId = personAssignedId;
	}
	public void setToolAssignedId(String toolAssignedId) {
		this.toolAssignedId = toolAssignedId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskMutable other = (TaskMutable) obj;
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
