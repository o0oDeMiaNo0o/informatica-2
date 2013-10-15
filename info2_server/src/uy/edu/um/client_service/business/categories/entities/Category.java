package uy.edu.um.client_service.business.categories.entities;

public class Category {

	private String nombre;

	public Category(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
