package uy.edu.um.services.people.clients.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteClientException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class TestAllClients {
	public static void main(String[] args){
		ClientMgt cMgt = ServiceFacade.getInstance().getClientMgt();
		String nombre = "pablo";
		String apellido = "lk;j";
		String direccion = "asdfgf";
		String email = "asdfsdfh";
		BigDecimal descuento = new BigDecimal(34);
		int tel = 45246; int ci = 23456;
		ClientVO toAdd = new ClientVO(nombre,apellido,ci,tel,direccion,email,descuento);
		try {
			System.out.println(cMgt.existeCliente(nombre,ci));
		} catch (ExisteClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
