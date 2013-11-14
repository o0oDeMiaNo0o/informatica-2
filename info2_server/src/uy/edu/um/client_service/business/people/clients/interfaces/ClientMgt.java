package uy.edu.um.client_service.business.people.clients.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.user.UserVO;

public interface ClientMgt {

	public void addClient(Client c) throws NoDatabaseConnection;

	public void editClient(Client c);

	public void removeClient(Client c);

	public Client getClient(ClientVO c);

	public void consultClient(int ci);

	public void getClients() throws NoDatabaseConnection;

	public ArrayList<ClientVO> allClients() throws NoDatabaseConnection;

	public ClientVO getClientVO(Client c);

	public boolean existeClient(String nombre, int ci) throws NoDatabaseConnection;
}
