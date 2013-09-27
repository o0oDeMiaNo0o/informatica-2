package uy.edu.um.value_object.article;

import java.io.Serializable;

public class ArticleVO implements Serializable{

	private String nombre;
	private int precio, numProducto;

	public ArticleVO(int numProducto, String nombre, int precio) {
		this.nombre=nombre;
		this.numProducto = numProducto;
		this.precio=precio;
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

	public int getNumProducto() {
		return numProducto;
	}

	public void setNumProducto(int numProducto) {
		this.numProducto = numProducto;
	}



}

