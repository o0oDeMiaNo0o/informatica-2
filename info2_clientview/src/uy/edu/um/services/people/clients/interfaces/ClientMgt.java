package uy.edu.um.services.people.clients.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteClientException;
import uy.edu.um.value_object.people.client.ClientVO;

public interface ClientMgt {

	public ClientVO createClientVO(String nombre, String apellido,int ci, int tel, String direccion, String mail
			, BigDecimal descuento);

	//public void addClient(String nombre, String apellido,int ci, int tel, String direccion, String mail);

	public void addClientVO(ClientVO c);

	public void removeClientVO(ClientVO c);

	public void editClientVO(ClientVO c);

	public void getClient(int ci);

	public ArrayList<ClientVO> allClients();

	public boolean existeCliente(String nombre, int ci) throws ExisteClientException;


}
