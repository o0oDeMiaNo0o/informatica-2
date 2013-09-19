package uy.edu.um.value_object.article;

public class ArticleVO {

	private String nombre;
	private int precio;

	public ArticleVO(String nombre, int precio) {
		this.nombre=nombre;
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



}

