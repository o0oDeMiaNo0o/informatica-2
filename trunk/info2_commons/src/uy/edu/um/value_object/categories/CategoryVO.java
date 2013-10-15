package uy.edu.um.value_object.categories;

import java.io.Serializable;

public class CategoryVO implements Serializable{
	private String nombre;
	private int id;

	public CategoryVO(int id,String nombre) {
		this.nombre=nombre;
		this.id = id;
	}

	public CategoryVO(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
