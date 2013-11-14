package uy.edu.um.client_service.service.tableRemote.managers;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
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
	public void addTable() throws RemoteException, NoDatabaseConnection {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		tMgt.addTable();
	}


	@Override
	public ArrayList<TableVO> allTables() throws RemoteException, NoDatabaseConnection {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		ArrayList<TableVO> array = new ArrayList<TableVO>(10);
		array = tMgt.allTables();
		return array;
	}

	@Override
	public void closeTable(TableVO t) throws RemoteException, NoDatabaseConnection {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		Table toClose = tMgt.getTable(t);
		tMgt.closeTable(toClose);

	}

	@Override
	public void openTable(TableVO t) throws RemoteException, NoDatabaseConnection {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		Table toOpen = tMgt.getTable(t);
		tMgt.openTable(toOpen);

	}

	@Override
	public void setOcupado(TableVO t) throws RemoteException, NoDatabaseConnection {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		Table ocupar = tMgt.getTable(t);
		tMgt.setOcupado(ocupar);

	}

	@Override
	public void removeTable(TableVO t) throws RemoteException {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		Table toRemove = tMgt.getTable(t);
		tMgt.removeTable(toRemove);
	}

	@Override
	public void setLibre(TableVO t) throws RemoteException, NoDatabaseConnection {
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		Table aLiberar = tMgt.getTable(t);
		tMgt.setLibre(aLiberar);

	}


}
