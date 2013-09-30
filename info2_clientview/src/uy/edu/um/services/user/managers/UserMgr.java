package uy.edu.um.services.user.managers;

import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class UserMgr implements UserMgt{

	private static UserMgr instance = null;

	private UserMgr(){}

	public static UserMgr getInstance(){
		if(instance == null){
			instance = new UserMgr();
		}
		return instance;
	}

	@Override
	public void addUser(UserVO a) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO createUserVO(String nombre, String password, boolean admin) {
		UserVO u = new UserVO(nombre,password,admin);
		return u;

	}

	@Override
	public void searchUser(String nombre) {
		// TODO Auto-generated method stub

	}

}
