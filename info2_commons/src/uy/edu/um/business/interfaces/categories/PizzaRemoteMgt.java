package uy.edu.um.business.interfaces.categories;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PizzaRemoteMgt extends Remote{

	public void addPizza() throws RemoteException;

	public void removePizza() throws RemoteException;

	public void editPizza() throws RemoteException;

}
