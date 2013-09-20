package uy.edu.um.client_service.business.article.entities;

public class Article {

	private int id;
	private String nombre;
	private int precio;

	public Article(int id, String nombre, int precio) {
		this.id = id;
		this.nombre=nombre;
		this.precio=precio;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
