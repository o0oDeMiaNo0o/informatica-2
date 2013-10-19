package uy.edu.um.client_service.service.tableRemote.managers;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
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

	@Override
	public ArrayList<TableVO> allTables() throws RemoteException {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		ArrayList<TableVO> array = new ArrayList<TableVO>(10);
		array = tMgt.allTables();
		return array;
	}

}
