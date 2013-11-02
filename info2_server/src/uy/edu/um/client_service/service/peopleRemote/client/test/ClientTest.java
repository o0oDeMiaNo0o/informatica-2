package uy.edu.um.client_service.service.peopleRemote.client.test;

import java.math.BigDecimal;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;


public class ClientTest {

	public static void main(String[] args) {
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		String nombre = "pablo";
		String apellido = "lk;j";
		String direccion = "asdfgf";
		String email = "asdfsdfh";
		BigDecimal descuento = new BigDecimal(34);
		int tel = 45246; int ci = 23456;
		ClientVO toAdd = new ClientVO(nombre,apellido,ci,tel,direccion,email,descuento);
		Client cAdd = cMgt.getClient(toAdd);
		System.out.println(cMgt.existeClient(nombre,ci));

	}

}
