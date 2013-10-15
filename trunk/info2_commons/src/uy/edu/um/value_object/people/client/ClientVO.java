package uy.edu.um.value_object.people.client;

import java.io.Serializable;


public class ClientVO implements Serializable {

	private String nombre, apellido, email, direccion;
	private int ci, tel, id;

	public ClientVO(String nombre, String apellido,int ci, int tel, String direccion, String email){
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.direccion = direccion;
		this.email = email;
	}
	
	public ClientVO(int id,int ci, String nombre, String apellido, int tel, String direccion, String email){
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.direccion = direccion;
		this.email = email;
	}
	
	

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}


}
