package uy.edu.um.business.interfaces.categories;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HamburguesaRemoteMgt extends Remote{

	public void addBurguer() throws RemoteException;

	public void removeBurguer() throws RemoteException;

	public void editBurguer() throws RemoteException;

}
