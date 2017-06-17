package com.golf.app.domain;

public class EmployeeMutable {
	private  String id;
	private  String nombre;
	private  String apellido1;
	private  String apellido2;
	private  String imagen;
	private  String posicion;
	
	
public EmployeeMutable(String id, String nombre, String apellido1, String apellido2, String imagen, String posicion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.imagen = imagen;
		this.posicion = posicion;
	}

	public Employee inmutable(){
		return Employee.of(this.getId(),this.getNombre(),this.getApellido1(),this.getApellido2(),this.getImagen(),this.getPosicion());
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


	public void setId(String id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


}
