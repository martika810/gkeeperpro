package com.golf.app.domain;

public class EmployeeMutable {
	private String id;
	private String name;
	private String surname;
	private String apellido2;
	private String image;
	private String position;

	public EmployeeMutable(String id, String name, String surname, String image, String position) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.image = image;
		this.position = position;
	}

	public EmployeeMutable(String id) {
		this.id = id;
	}

	public Employee inmutable() {
		return Employee.of(this.getId(), this.getName(), this.getSurname(),  this.getImage(), this.getPosition());
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	

	public String getImage() {
		return image;
	}

	public String getPosition() {
		return position;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}



	public void setImage(String image) {
		this.image = image;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
