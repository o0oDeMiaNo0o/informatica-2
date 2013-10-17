package uy.edu.um.interfaces.table;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface TableRemoteMgt extends Remote{

	public void addTable() throws RemoteException;

	public void closeTable() throws RemoteException;

	public void addOrderToTable(TableVO t, OrderVO o) throws RemoteException;

	public void openTable() throws RemoteException;

}
