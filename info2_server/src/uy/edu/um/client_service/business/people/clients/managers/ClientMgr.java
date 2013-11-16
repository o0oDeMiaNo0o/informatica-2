package uy.edu.um.client_service.business.people.clients.managers;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.persistance.DAO.clients.ClientDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.people.client.ClientVO;

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
	public void addClient(Client c) throws NoDatabaseConnection {
		ClientDAO dao = ClientDAO.getInstance();
		dao.addClient(c);
	}

	@Override
	public void editClient(Client c) throws NoDatabaseConnection {
		ClientDAO dao = ClientDAO.getInstance();
		dao.editClient(c);

	}

	@Override
	public void consultClient(int ci) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeClient(Client c) throws NoDatabaseConnection {
		ClientDAO dao = ClientDAO.getInstance();
		dao.removeClient(c);
	}

	@Override
	public Client getClient(ClientVO c) {
		int id = c.getId();
		String nombre = c.getNombre();
		String apellido = c.getApellido();
		String mail = c.getEmail();
		String direccion = c.getDireccion();
		int tel = c.getTel();
		int ci = c.getCi();
		BigDecimal descuento = c.getDescuento();
		Client toReturn = new Client(id,nombre,apellido,ci,tel,direccion,mail,descuento);
		return toReturn;
	}

	@Override
	public void getClients() throws NoDatabaseConnection {
		ClientDAO dao = ClientDAO.getInstance();
		dao.getClients();
	}

	@Override
	public ArrayList<ClientVO> allClients() throws NoDatabaseConnection {
		//manager
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();

		ClientDAO dao = ClientDAO.getInstance();
		ArrayList<Client> clients =  dao.getClients();
		ArrayList<ClientVO> toReturn = new ArrayList<ClientVO>(10);
		for(Client c : clients){
			if(c!=null){
				ClientVO tAdd = cMgt.getClientVO(c);
				toReturn.add(tAdd);
			}
		}
		return toReturn;
	}

	@Override
	public ClientVO getClientVO(Client c) {
		String nombre = c.getNombre();
		String apellido = c.getApellido();
		String direccion = c.getDireccion();
		String email = c.getMail();
		int id = c.getId();
		int ci = c.getCi();
		int tel = c.getTel();
		BigDecimal descuento = c.getDescuento();
		return new ClientVO(id,ci,nombre,apellido,tel,direccion,email,descuento);
	}

	@Override
	public boolean existeClient(String nombre, int ci) throws NoDatabaseConnection {
		ClientDAO dao = ClientDAO.getInstance();
		return dao.existeCliente(nombre,ci);
	}

}
