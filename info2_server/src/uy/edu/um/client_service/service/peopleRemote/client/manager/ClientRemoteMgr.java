package uy.edu.um.client_service.service.peopleRemote.client.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.interfaces.people.clients.ClientRemoteMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class ClientRemoteMgr implements ClientRemoteMgt{

	private static ClientRemoteMgr instance = null;

	private ClientRemoteMgr(){}

	public static ClientRemoteMgr getInstance(){
		if (instance == null){
			instance = new ClientRemoteMgr();
		}
		return instance;
	}


	@Override
	public void addClient(ClientVO c) throws RemoteException {
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		Client toAdd = cMgt.getClient(c);
		cMgt.addClient(toAdd);
	}

	@Override
	public void editClient(ClientVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}



	@Override
	public void removeClient(ClientVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void showClient(ClientVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<ClientVO> allClients() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
