package uy.edu.um.client_service.business.article.entities;

public class Article {

	private int prodN;
	private String nombre;
	private int precio;

	public Article(int prodN, String nombre, int precio) {
		this.prodN = prodN;
		this.nombre=nombre;
		this.precio=precio;
	}



	public int getProdN() {
		return prodN;
	}



	public void setProdN(int prodN) {
		this.prodN = prodN;
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
