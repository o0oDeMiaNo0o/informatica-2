package uy.edu.um.business.value_object.articles;

public class ArticleVO {

	//Atributos
	private int id, precio;
	private String nombre;

	//Getters y setters

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

	//Constructor

	public ArticleVO(int id, String nombre, int precio){
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}



}
