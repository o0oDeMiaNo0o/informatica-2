package uy.edu.um.client_service.service.tableRemote.managers;

import java.rmi.RemoteException;

import uy.edu.um.interfaces.table.TableRemoteMgt;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public class TableRemoteMgr implements TableRemoteMgt{

	private static TableRemoteMgr instance = null;

	private TableRemoteMgr(){}

	public static TableRemoteMgr getInstance(){
		if(instance == null){
			instance = new TableRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addOrderToTable(TableVO t, OrderVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTable() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeTable() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openTable() throws RemoteException {
		// TODO Auto-generated method stub

	}

}
