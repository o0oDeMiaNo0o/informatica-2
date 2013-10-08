package uy.edu.um.client_service.business.categories.entities;

public class Category {

	private int id;
	private String nombre;

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
