package uy.edu.um.client_service.service.userRemote.test;

import java.rmi.RemoteException;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class test2 {
	public static void main(String[] args) throws RemoteException, NoDatabaseConnection{
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		String nombre = "Daniel";
		String pass = "user";
		String crypted = uMgt.hashPassword(pass);
		System.out.println(crypted);
	}
}
