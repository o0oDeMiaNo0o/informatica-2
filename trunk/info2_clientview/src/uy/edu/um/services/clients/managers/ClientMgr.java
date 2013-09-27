package uy.edu.um.services.clients.managers;

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
		// TODO Auto-generated method stub

	}

}
