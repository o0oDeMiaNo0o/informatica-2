package uy.edu.um.value_object.article;

import java.io.Serializable;
import java.math.BigDecimal;

import uy.edu.um.value_object.categories.CategoryVO;

public class ArticleVO implements Serializable{

	private String nombre;
	private BigDecimal precio;
	private int numProducto;
	private CategoryVO category;

	public ArticleVO(int numProducto, String nombre, BigDecimal precio, CategoryVO category) {
		this.nombre=nombre;
		this.numProducto = numProducto;
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

	public int getNumProducto() {
		return numProducto;
	}

	public void setNumProducto(int numProducto) {
		this.numProducto = numProducto;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}



}

