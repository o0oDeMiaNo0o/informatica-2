package uy.edu.um.services.clients.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.interfaces.clients.ClientRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.client.ClientVO;

public class ClientMgr implements ClientMgt{

	private static ClientMgr instance = null;

	private ClientMgr(){};

	public static ClientMgr getInstance(){
		if(instance == null){
			instance = new ClientMgr();
		}
		return instance;
	}

	@Override
	public ClientVO createClientVO(String nombre, String apellido, int ci,
			int tel, String direccion, String mail) {
		ClientVO toReturn = new ClientVO(nombre,apellido,ci,tel,direccion,mail);
		return toReturn;
	}

	@Override
	public void sendClientVO(ClientVO c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCliente() {
		try {

			String sObjectService = "ClientRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ClientRemoteMgt oArticleRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);


			ClientMgt aMgt = ServiceFacade.getInstance().getClientMgt();

			int ci = 4518723;
			String nombre = "pedro";
			String apellido = "bermudez";
			String mail = "jbermu@gmail.com";
			String direccion = "soriano 1590";
			int tel = 452452345;

			ClientVO toSend = aMgt.createClientVO(nombre, apellido, ci, tel, direccion, mail);

			oArticleRemoteMgt.addClient(toSend);

			System.out.println("Cliente agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}



	@Override
	public void getClient(int ci) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addClient(String nombre, String apellido, int ci, int tel,
			String direccion, String mail) {
		// TODO Auto-generated method stub

	}

}
