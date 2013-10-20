package uy.edu.um.interfaces.table;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface TableRemoteMgt extends Remote{

	public ArrayList<TableVO> allTables() throws RemoteException;

	public void addTable() throws RemoteException;

	public void closeTable(TableVO t) throws RemoteException;

	public void addOrderToTable(TableVO t, OrderVO o) throws RemoteException;

	public void openTable(TableVO t) throws RemoteException;

}
