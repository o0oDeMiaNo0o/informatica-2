package uy.edu.um.client_service.business.categories.entities;

public class Category {

	private String nombre;
	private int id;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category(String nombre){
		this.nombre = nombre;
	}
	
	public Category(String nombre,int id){
		this.nombre = nombre;
		this.id=id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
