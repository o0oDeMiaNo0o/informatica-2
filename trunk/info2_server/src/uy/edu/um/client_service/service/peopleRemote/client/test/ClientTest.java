package uy.edu.um.client_service.service.peopleRemote.client.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.people.client.ClientVO;


public class ClientTest {

	public static void main(String[] args) throws NoDatabaseConnection {
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		ArrayList<ClientVO> allClients = new ArrayList<ClientVO>(2);
		allClients = cMgt.allClients();
	}

}
