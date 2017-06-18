package com.golf.app.domain;

import java.util.UUID;

public class Tool {
	private final String id;
	private final String nombre;
	private final String estado;
	private final String imagen;
	
	private Tool(String id, String nombre, String estado, String imagen) {
		
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.imagen = imagen;
	}
	
	// factoria...patron de diseño para crear los objetos más fácilmente 
	
	public static Tool of (final String nombre,final String estado, final String imagen)
	{
		return new Tool(UUID.randomUUID().toString(),nombre,estado,imagen);
	}

	protected static Tool of (final String id,final String nombre,final String estado, final String imagen)
	{
		return new Tool(id,nombre,estado,imagen);
	}
	
	public ToolMutable mutable()
	{
		return new ToolMutable(this.getId(),this.getNombre(),this.getEstado(),this.getImagen());
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}

	public String getImagen() {
		return imagen;
	}
	public Tool setImagen( final String imagen)
	{
		return new Tool (this.id,this.nombre,this.estado,imagen);
	}
	public Tool setNombre( final String nombre)
	{
		return new Tool (this.id,nombre,this.estado,this.imagen);
	}
	public Tool setEstado( final String estado)
	{
		return new Tool (this.id,this.nombre,estado,this.imagen);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Tool other = (Tool) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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
		return true;
	}
	
	
}
