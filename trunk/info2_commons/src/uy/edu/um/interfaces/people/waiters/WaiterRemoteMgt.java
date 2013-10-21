package uy.edu.um.interfaces.people.waiters;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.people.waiters.WaiterVO;

public interface WaiterRemoteMgt extends Remote{

	public void addWaiter(WaiterVO w) throws RemoteException;

	public void removeWaiter(WaiterVO w) throws RemoteException;

	public void editWaiter(WaiterVO w) throws RemoteException;

	public void showWaiter(WaiterVO w) throws RemoteException;

	public ArrayList<WaiterVO> allWaiters() throws RemoteException;
}
