package uy.edu.um.value_object.people.waiters;

import java.io.Serializable;

import uy.edu.um.value_object.people.entities.PeopleVO;

public class WaiterVO extends PeopleVO implements Serializable{

	private boolean trabajando;

	public WaiterVO(String nombre, String apellido, int ci, int tel,
			String direccion, String email, boolean trabajando) {
		super(nombre, apellido, ci, tel, direccion, email);
		this.trabajando = trabajando;
	}

	public boolean isTrabajando() {
		return trabajando;
	}

	public void setTrabajando(boolean trabajando) {
		this.trabajando = trabajando;
	}



}
