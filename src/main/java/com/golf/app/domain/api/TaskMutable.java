package com.golf.app.domain.api;

import java.util.UUID;

public class TaskMutable {
	private String id;
	private String description;
	private String personAssigned;

	public  TaskMutable(final String id, final String description, final String personAssigned){
		this.id=id;
		this.description = description;
		this.personAssigned = personAssigned;
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getPersonAssigned() {
		return personAssigned;
	}



	public void setPersonAssigned(String personAssigned) {
		this.personAssigned = personAssigned;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((personAssigned == null) ? 0 : personAssigned.hashCode());
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
		if (personAssigned == null) {
			if (other.personAssigned != null)
				return false;
		} else if (!personAssigned.equals(other.personAssigned))
			return false;
		return true;
	}
	
	
	
	
	

}
