package uy.edu.um.services.people.clients.test;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class test {
	public static void main(String[] args) throws NoServerConnectionException, NoDatabaseConnection{
		ClientMgt cmgt= ServiceFacade.getInstance().getClientMgt();
		ArrayList<ClientVO> allClients = cmgt.allClients();
		ClientVO a = allClients.get(1);
		a.setNombre("pepe");
		cmgt.editClient(a);
	}
}
