package uy.edu.um.business.value_object.article;

public class ArticleVO {
	//atributo
	private String nombre;
	private int precio;

	public ArticleVO(int id,String nombre, int precio) {
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
