package uy.edu.um.business.interfaces.categories;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BebidaRemoteMgt extends Remote{

	public void addDrink() throws RemoteException;

	public void removeDrink() throws RemoteException;

	public void editDrink() throws RemoteException;

}
