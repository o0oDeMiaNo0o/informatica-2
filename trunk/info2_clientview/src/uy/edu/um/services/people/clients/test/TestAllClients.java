package uy.edu.um.services.people.clients.test;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class TestAllClients {
	public static void main(String[] args){
		ArrayList<ClientVO> allClients = new ArrayList<ClientVO>(10);
		ClientMgt cMgt = ServiceFacade.getInstance().getClientMgt();
		allClients = cMgt.allClients();
		for (ClientVO c : allClients){
			System.out.println(c.getNombre()+", "+c.getApellido()+", "+c.getCi()+", "+c.getDireccion()
					+", "+c.getEmail());
		}
	}
}
