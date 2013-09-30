package uy.edu.um.services.clients.interfaces;

import uy.edu.um.value_object.client.ClientVO;

public interface ClientMgt {

	public ClientVO createClientVO(String nombre, String apellido,int ci, int tel, String direccion, String mail);

	public void addClient(String nombre, String apellido,int ci, int tel, String direccion, String mail);

	public void sendClientVO(ClientVO c);

	public void setCliente();

	public void getClient(int ci);

}
