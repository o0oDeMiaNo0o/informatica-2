package uy.edu.um.services.people.clients.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteClientException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.HasNumberException;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.people.client.ClientVO;

public interface ClientMgt {

	public ClientVO createClientVO(String nombre, String apellido,int ci, int tel, String direccion, String mail
			, BigDecimal descuento) throws ExisteClientException,
										HasBlanksException, HasNumberException, NoServerConnectionException;

	//public void addClient(String nombre, String apellido,int ci, int tel, String direccion, String mail);

	public void addClientVO(ClientVO c) throws NoServerConnectionException;

	public void removeClientVO(ClientVO c) throws NoServerConnectionException;

	public void editClientVO(ClientVO c) throws NoServerConnectionException;

	public void getClient(int ci)  throws NoServerConnectionException;

	public ArrayList<ClientVO> allClients() throws NoServerConnectionException;

	public boolean existeCliente(String nombre, int ci) throws NoServerConnectionException;


}
