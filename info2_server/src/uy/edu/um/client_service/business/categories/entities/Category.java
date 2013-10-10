package uy.edu.um.client_service.business.categories.entities;

public class Category {

	private int id;
	private String nombre;
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Category(String nombre, int id){
		this.id = id;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
