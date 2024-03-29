package uy.edu.um.client_service.business.article.entities;

import java.math.BigDecimal;

import uy.edu.um.client_service.business.categories.entities.Category;

public class Article {

	private int id;
	private String nombre;
	private BigDecimal precio;
	private Category category;

	public Article(String nombre, BigDecimal precio, Category category) {
		this.nombre=nombre;
		this.precio=precio;
		this.category = category;
	}


	public Article(int id,String nombre, BigDecimal precio, Category category) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.category = category;
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



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}
