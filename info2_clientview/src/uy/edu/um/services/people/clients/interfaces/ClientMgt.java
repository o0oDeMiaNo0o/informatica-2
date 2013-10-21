package uy.edu.um.services.people.clients.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.people.client.ClientVO;

public interface ClientMgt {

	public ClientVO createClientVO(String nombre, String apellido,int ci, int tel, String direccion, String mail
			, int descuento);

	//public void addClient(String nombre, String apellido,int ci, int tel, String direccion, String mail);

	public void sendClientVO(ClientVO c);

	public void getClient(int ci);

	public ArrayList<ClientVO> allClients();

}
