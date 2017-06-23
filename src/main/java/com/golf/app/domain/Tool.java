package com.golf.app.domain;

import java.util.UUID;

public class Tool {
	
	public final static String EMPTY = "UNASSIGNED";;
	
	private final String id;
	private final String name;
	private final String state;
	private final String image;
	
	private Tool(String id, String name, String state, String image) {
		
		this.id = id;
		this.name = name;
		this.state = state;
		this.image = image;
	}
	
	// factoria...patron de diseño para crear los objetos más fácilmente 
	
	public static Tool of (final String name,final String state, final String image)
	{
		return new Tool(UUID.randomUUID().toString(),name,state,image);
	}

	protected static Tool of (final String id,final String name,final String state, final String image)
	{
		return new Tool(id,name,state,image);
	}
	
	public ToolMutable mutable()
	{
		return new ToolMutable(this.getId(),this.getName(),this.getState(),this.getImage());
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getImage() {
		return image;
	}
	public Tool setImage( final String image)
	{
		return new Tool (this.id,this.name,this.state,image);
	}
	public Tool setName( final String name)
	{
		return new Tool (this.id,name,this.state,this.image);
	}
	public Tool setState( final String state)
	{
		return new Tool (this.id,this.name,state,this.image);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}


	
	
}
