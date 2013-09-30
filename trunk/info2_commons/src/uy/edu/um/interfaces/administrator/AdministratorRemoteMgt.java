package uy.edu.um.interfaces.administrator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.administraor.AdministratorVO;

public interface AdministratorRemoteMgt extends Remote{

	public void addAdministrator(AdministratorVO a) throws RemoteException;

	public void deleteAdministrator(AdministratorVO a) throws RemoteException;

	public void editAdministrator(AdministratorVO a) throws RemoteException;
	
	

}
