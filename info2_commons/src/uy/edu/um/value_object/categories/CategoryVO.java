package uy.edu.um.value_object.categories;

public class CategoryVO {
	private String nombre;
	private int precio,numProducto;

	public CategoryVO(int numProducto, String nombre, int precio) {
		this.nombre=nombre;
		this.precio=precio;
		this.numProducto = numProducto;
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
