package uy.edu.um.services.people.clients.test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import uy.edu.um.interfaces.people.clients.ClientRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class ClientTest {
	public static void main(String[] args) {

		try {

			String sObjectService = "ClientRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ClientRemoteMgt oArticleRemoteMgt = (ClientRemoteMgt) oRegitry.lookup(sObjectService);


			String nombre = "matias";
			String apellido = "liston";
			String direccion = "asd";
			String mail = "mliston";
			int ci = 12345;
			int tel = 12345345;

			ClientMgt aMgt = ServiceFacade.getInstance().getClientMgt();

			ClientVO toSend = aMgt.createClientVO(nombre,apellido,ci,tel,direccion,mail);

			oArticleRemoteMgt.addClient(toSend);

			System.out.println("cliente agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}
