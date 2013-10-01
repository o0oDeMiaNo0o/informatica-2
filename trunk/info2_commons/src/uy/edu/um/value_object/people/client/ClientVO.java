package uy.edu.um.value_object.people.client;

import java.io.Serializable;

import uy.edu.um.value_object.people.entities.PeopleVO;

public class ClientVO  extends PeopleVO implements Serializable{



	public ClientVO(String nombre, String apellido, int ci, int tel,
			String direccion, String email) {
		super(nombre, apellido, ci, tel, direccion, email);
		// TODO Auto-generated constructor stub
	}
	//atributos


}
