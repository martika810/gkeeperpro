package com.golf.app.domain;


public class TaskMutable {
	private String id;
	private String title;
	private String description;
	private String personAssigned;

	public  TaskMutable(final String id, final String title, final String description, final String personAssigned){
		this.id=id;
		this.title = title;
		this.description = description;
		this.personAssigned = personAssigned;
	}
	
	public Task inmutable(){
		return Task.of(this.getId(),this.getTitle(),this.getDescription(),this.getPersonAssigned());
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



	public String getPersonAssigned() {
		return personAssigned;
	}



	public void setPersonAssigned(String personAssigned) {
		this.personAssigned = personAssigned;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TaskMutable that = (TaskMutable) o;

		if (!id.equals(that.id)) return false;
		if (!title.equals(that.title)) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		return personAssigned.equals(that.personAssigned);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + personAssigned.hashCode();
		return result;
	}
}
