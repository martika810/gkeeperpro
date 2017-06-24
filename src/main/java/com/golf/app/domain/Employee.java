package com.golf.app.domain;

import java.util.UUID;

public final class Employee extends BaseObject<EmployeeMutable, String> {

	public final static String EMPTY = "UNASSIGNED";;

	private final String id;
	private final String name;
	private final String surname;
	private final String image;
	private final String position;

	private Employee(String id, String name, String surname, String image, String position) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.image = image;
		this.position = position;
	}

	public static Employee of(final String name, final String surname, final String image, final String position) {
		return new Employee(UUID.randomUUID().toString(), name, surname, image, position);
	}

	public static Employee of(final String id, final String name, final String surname, final String image, final String position) {
		return new Employee(id, name, surname, image, position);

	}
	// para que se pueda convertir de normal a mutable
	public EmployeeMutable mutable() {
		return new EmployeeMutable(this.getId(), this.getName(), this.getSurname(), this.getImage(), this.getPosition());
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

	public Employee setNombre(final String nombre) {
		return new Employee(this.id, name, this.surname, this.image, this.position);
	}

	public Employee setSurname(final String surname) {
		return new Employee(this.id, this.name, surname, this.image, this.position);
	}

	public Employee setImagen(final String imagen) {
		return new Employee(this.id, this.name, this.surname, imagen, this.position);
	}
	public Employee setPosition(final String position) {
		return new Employee(this.id, this.name, this.surname, this.image, position);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
