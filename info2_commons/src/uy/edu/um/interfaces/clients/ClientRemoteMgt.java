package uy.edu.um.interfaces.clients;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.client.ClientVO;

public interface ClientRemoteMgt extends Remote{

	public void addClient(ClientVO c) throws RemoteException;

	public void showClient(ClientVO c)throws RemoteException;

	public void removeClient(ClientVO c) throws RemoteException;

	public void editClient(ClientVO c) throws RemoteException;

}
