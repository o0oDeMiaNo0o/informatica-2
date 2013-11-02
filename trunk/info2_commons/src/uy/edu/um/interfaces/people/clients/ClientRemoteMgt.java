package uy.edu.um.interfaces.people.clients;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.people.client.ClientVO;

public interface ClientRemoteMgt extends Remote{

	public void addClient(ClientVO c) throws RemoteException;

	public void showClient(ClientVO c)throws RemoteException;

	public void removeClient(ClientVO c) throws RemoteException;

	public void editClient(ClientVO c) throws RemoteException;

	public ArrayList<ClientVO> allClients() throws RemoteException;

	public boolean existeCliente(String nombre, int ci) throws RemoteException;

}
