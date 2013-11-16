package uy.edu.um.interfaces.people.clients;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.people.client.ClientVO;

public interface ClientRemoteMgt extends Remote{

	public void addClient(ClientVO c) throws RemoteException, NoDatabaseConnection;

	public void showClient(ClientVO c)throws RemoteException;

	public void removeClient(ClientVO c) throws RemoteException, NoDatabaseConnection;

	public void editClient(ClientVO c) throws RemoteException, NoDatabaseConnection;

	public ArrayList<ClientVO> allClients() throws RemoteException, NoDatabaseConnection;

	public boolean existeCliente(String nombre, int ci) throws RemoteException, NoDatabaseConnection;

}
