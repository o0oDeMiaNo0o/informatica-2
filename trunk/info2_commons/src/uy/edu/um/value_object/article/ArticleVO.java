package uy.edu.um.value_object.article;

import java.io.Serializable;
import java.math.BigDecimal;

public class ArticleVO implements Serializable{

	private String nombre;
	private BigDecimal precio;
	private int numProducto;

	public ArticleVO(int numProducto, String nombre, BigDecimal precio) {
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getNumProducto() {
		return numProducto;
	}

	public void setNumProducto(int numProducto) {
		this.numProducto = numProducto;
	}



}

