package uy.edu.um.client_service.service.userRemote.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.interfaces.user.UserRemoteMgt;
import uy.edu.um.value_object.user.UserVO;

public class test2 {
	public static void main(String[] args) throws RemoteException, NoDatabaseConnection{
		UserMgt umgt = BusinessFacade.getInstance().getUserMgt();
		UserRemoteMgt uMgt = BusinessFacade.getInstance().getUserRemote();
		ArrayList<UserVO> allUsers = umgt.allUsers();
		UserVO u = allUsers.get(2);
		uMgt.deleteUser(u);
	}
}
