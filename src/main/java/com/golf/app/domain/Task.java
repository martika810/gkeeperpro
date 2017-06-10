package com.golf.app.domain;

import java.util.UUID;

import com.golf.app.domain.api.TaskMutable;

public final class Task {
	private final String id;
	private final String description;
	private final String personAssigned;
	
	public static Task of(final String description){
		return new Task(UUID.randomUUID().toString(),description, "UnAssigned");
	}
	
	public static Task of(final String description, final String person){
		return new Task(UUID.randomUUID().toString(),description,person);
	}
	
	public TaskMutable toMutable(){
		return new TaskMutable(this.id(),this.description(),this.personAssigned());
	}
	
	private Task(final String id, final String description, final String personAssigned){
		this.id=id;
		this.description = description;
		this.personAssigned = personAssigned;
	}
	
	public String id(){return id;}
	public String description(){return description;}
	public String personAssigned(){return personAssigned;}
	
	public Task withDescription(final String description){
		return new Task(this.id,description,this.personAssigned);
	}
	
	public Task withPersonAssigned(final String person){
		return new Task(this.id,this.description,person);
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
		if (personAssigned == null) {
			if (other.personAssigned != null)
				return false;
		} else if (!personAssigned.equals(other.personAssigned))
			return false;
		return true;
	}
	
	
	
	
	

}
