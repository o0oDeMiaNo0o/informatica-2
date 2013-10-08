package uy.edu.um.value_object.categories;

public class CategoryVO {
	private String nombre;
	private int id;

	public CategoryVO(String nombre,int id) {
		this.nombre=nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
