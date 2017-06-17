package com.golf.app.domain;

import java.util.UUID;

public final class Task {
	private final String id;
	private final String title;
	private final String description;
	private final String personAssigned;
	
	public static Task of(final String title, final String description){
		return new Task(UUID.randomUUID().toString(),title,description, "UnAssigned");
	}
	
	public static Task of(final String title,final String description, final String person){
		return new Task(UUID.randomUUID().toString(),title,description,person);
	}

	static Task of(final String id, final String title,final String description, final String person){
		return new Task(id,title,description,person);
	}
	
	public TaskMutable mutable(){
		return new TaskMutable(this.id(),this.title(),this.description(),this.personAssigned());
	}
	
	private Task(final String id, final String title,final String description, final String personAssigned){
		this.id=id;
		this.title = title;
		this.description = description;
		this.personAssigned = personAssigned;
	}
	
	public String id(){return id;}
	public String title(){return title;}
	public String description(){return description;}
	public String personAssigned(){return personAssigned;}

	public Task withTitle(final String title){ return new Task(this.id,title,this.description,this.personAssigned);}
	
	public Task withDescription(final String description){
		return new Task(this.id,this.title,description,this.personAssigned);
	}
	
	public Task withPersonAssigned(final String person){
		return new Task(this.id,this.title,this.description,person);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Task task = (Task) o;

		if (!id.equals(task.id)) return false;
		if (!title.equals(task.title)) return false;
		if (description != null ? !description.equals(task.description) : task.description != null) return false;
		return personAssigned.equals(task.personAssigned);

	}

	@Override			//mejora la eficiencia de los maps
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + personAssigned.hashCode();
		return result;
	}
}
