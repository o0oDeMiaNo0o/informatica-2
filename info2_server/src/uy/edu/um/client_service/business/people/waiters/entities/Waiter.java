package uy.edu.um.client_service.business.people.waiters.entities;

public class Waiter{

	private String nombre, apellido, direccion, mail;
	private int tel, ci;

	//getters y setter

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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	//constructor
	public Waiter(String nombre, String apellido,int ci, int tel, String direccion, String mail){
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.direccion = direccion;
		this.mail = mail;
	}

}
