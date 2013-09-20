package uy.edu.um.services.article.value_object;

import java.io.Serializable;

public class ArticleVO implements Serializable{

	//atributos
	private String nombre;
	private int precio;

	//constructor
	public ArticleVO(String nombre, int precio){
		this.precio = precio;
		this.nombre = nombre;
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
