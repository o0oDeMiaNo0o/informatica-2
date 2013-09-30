package uy.edu.um.client_service.business.clients.interfaces;

import uy.edu.um.client_service.business.clients.entities.Client;
import uy.edu.um.value_object.client.ClientVO;

public interface ClientMgt {

	public void addClient(Client c);

	public void editClient(Client c);

	public void removeClient(Client c);

	public Client getClient(ClientVO c);

	public void consultClient(int ci);

	public void getClients();



}
