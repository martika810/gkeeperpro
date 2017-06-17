package com.golf.app.domain;

import java.util.UUID;

public final class Employee {
	private final String id;
	private final String nombre;
	private final String apellido1;
	private final String apellido2;
	private final String imagen;
	private final String posicion;
	
	private Employee(String id, String nombre, String apellido1, String apellido2, String imagen, String posicion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.imagen = imagen;
		this.posicion = posicion;
	}
	public static Employee of(final String nombre, final String apellido1,final String apellido2,final String imagen,final String posicion){
		return new Employee(UUID.randomUUID().toString(),nombre,apellido1,apellido2,imagen,posicion);
	}
	
	protected static Employee of(final String id,final String nombre, final String apellido1,final String apellido2,final String imagen,final String posicion){
		return new Employee(id,nombre,apellido1,apellido2,imagen,posicion);
	}
	
	//para que se pueda convertir de normal a mutable
	public EmployeeMutable mutable(){
		return new EmployeeMutable(this.getId(),this.getNombre(),this.getApellido1(),this.getApellido2(),this.getImagen(),this.getPosicion());
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getImagen() {
		return imagen;
	}

	public String getPosicion() {
		return posicion;
	}
	
	public Employee setNombre( final String nombre){
		return new Employee (this.id,nombre,this.apellido1,this.apellido2,this.imagen,this.posicion);
	}
	
	public Employee setApellido1( final String apellido1){
		return new Employee (this.id,this.nombre,apellido1,this.apellido2,this.imagen,this.posicion);
	}
	public Employee setApellido2( final String apellido2){
		return new Employee (this.id,this.nombre,this.apellido1,apellido2,this.imagen,this.posicion);
	}
	public Employee setImagen( final String imagen){
		return new Employee (this.id,this.nombre,this.apellido1,this.apellido2,imagen,this.posicion);
	}
	public Employee setPosicion( final String posicion){
		return new Employee (this.id,this.nombre,this.apellido1,this.apellido2,this.imagen,posicion);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
		if (apellido1 == null) {
			if (other.apellido1 != null)
				return false;
		} else if (!apellido1.equals(other.apellido1))
			return false;
		if (apellido2 == null) {
			if (other.apellido2 != null)
				return false;
		} else if (!apellido2.equals(other.apellido2))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	
	
}
