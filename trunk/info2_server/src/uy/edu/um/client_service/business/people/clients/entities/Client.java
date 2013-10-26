package uy.edu.um.client_service.business.people.clients.entities;

import java.math.BigDecimal;

public class Client{

	//atributos
	private String nombre, apellido, direccion, mail;
	private int tel, ci, id;
	private BigDecimal descuento;

	//getters y setter

	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//constructor
	public Client(String nombre, String apellido,int ci, int tel, String direccion, String mail, BigDecimal descuento){
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.direccion = direccion;
		this.mail = mail;
		this.descuento = descuento;
	}

	public Client(int id,String nombre, String apellido,int ci, int tel, String direccion, String mail, BigDecimal descuento){
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.direccion = direccion;
		this.mail = mail;
		this.descuento = descuento;
		this.id=id;
	}

}
