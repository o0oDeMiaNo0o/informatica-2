package uy.edu.um.client_service.business.clients.managers;

import uy.edu.um.client_service.business.clients.entities.Client;
import uy.edu.um.client_service.business.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.persistance.DAO.clients.ClientDAO;
import uy.edu.um.value_object.client.ClientVO;

public class ClientMgr implements ClientMgt{

	public static ClientMgr instance = null;

	private ClientMgr(){

	}

	public static ClientMgr getInstance(){
		if (instance == null){
			instance = new ClientMgr();
		}
		return instance;
	}

	@Override
	public void addClient(Client c) {
		ClientDAO dao = ClientDAO.getInstance();
		dao.addClient(c);
	}

	@Override
	public void editClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultClient(int ci) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client getClient(ClientVO c) {
		String nombre = c.getNombre();
		String apellido = c.getApellido();
		String mail = c.getMail();
		String direccion = c.getDireccion();
		int tel = c.getTel();
		int ci = c.getCi();
		Client toReturn = new Client(nombre,apellido,ci,tel,direccion,mail);
		return toReturn;
	}

	@Override
	public void getClients() {
		ClientDAO dao = ClientDAO.getInstance();
		dao.getClients();
	}

}
