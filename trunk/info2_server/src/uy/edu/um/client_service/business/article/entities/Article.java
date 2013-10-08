package uy.edu.um.client_service.business.article.entities;

import java.math.BigDecimal;

public class Article {

	private int prodN;
	private String nombre;
	private BigDecimal precio;

	public Article(int prodN, String nombre, BigDecimal precio) {
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



	public BigDecimal getPrecio() {
		return precio;
	}



	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


}
