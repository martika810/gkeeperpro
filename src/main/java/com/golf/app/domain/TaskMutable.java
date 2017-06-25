package com.golf.app.domain;

import java.util.List;

public class TaskMutable {
	private String id;
	private String title;
	private String description;
	private List<String> personAssignedIds;
	private String toolAssignedId;

	public TaskMutable() {
	}

	public TaskMutable(String id, String title, String description, List<String> personAssignedIds, String toolAssignedId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.personAssignedIds = personAssignedIds;
		this.toolAssignedId = toolAssignedId;
	}

	public Task inmutable() {
		return Task.of(this.getId(), this.getTitle(), this.getDescription(), this.getPersonAssignedIds(), this.getToolAssignedId());
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

	public List<String> getPersonAssignedIds() {
		return personAssignedIds;
	}

	public String getToolAssignedId() {
		return toolAssignedId;
	}

	public void setPersonAssignedId(List<String> personAssignedIds) {
		this.personAssignedIds = personAssignedIds;
	}
	public void setToolAssignedId(String toolAssignedId) {
		this.toolAssignedId = toolAssignedId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personAssignedIds == null) ? 0 : personAssignedIds.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toolAssignedId == null) ? 0 : toolAssignedId.hashCode());
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
		if (toolAssignedId == null) {
			if (other.toolAssignedId != null)
				return false;
		} else if (!toolAssignedId.equals(other.toolAssignedId))
			return false;
		return true;
	}

}
