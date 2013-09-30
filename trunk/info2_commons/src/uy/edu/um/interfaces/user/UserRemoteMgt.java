package uy.edu.um.interfaces.user;

import java.rmi.Remote;
import java.rmi.RemoteException;
import uy.edu.um.value_object.user.UserVO;


public interface UserRemoteMgt extends Remote{

	public void addUser(UserVO u) throws RemoteException;

	public void deleteUser(UserVO a) throws RemoteException;

	public void editUser(UserVO a) throws RemoteException;



}
