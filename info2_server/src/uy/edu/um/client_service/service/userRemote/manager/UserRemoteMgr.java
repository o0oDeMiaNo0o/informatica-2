package uy.edu.um.client_service.service.userRemote.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.interfaces.user.UserRemoteMgt;
import uy.edu.um.value_object.user.UserVO;

public class UserRemoteMgr implements UserRemoteMgt{

	private static UserRemoteMgr instance = null;

	private UserRemoteMgr(){

	}

	public static UserRemoteMgr getInstance(){
		if (instance == null){
			instance = new UserRemoteMgr();
		}
		return instance;
	}


	@Override
	public void addUser(UserVO u) throws RemoteException {
		// TODO Auto-generated method stub
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		User toAdd = uMgt.getUser(u);
		uMgt.addUser(toAdd);

	}

	@Override
	public void deleteUser(UserVO a) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void editUser(UserVO a) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<UserVO> allUsers() throws RemoteException {
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		return null;
	}

}
