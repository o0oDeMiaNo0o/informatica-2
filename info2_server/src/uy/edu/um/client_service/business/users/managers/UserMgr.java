package uy.edu.um.client_service.business.users.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.client_service.persistance.DAO.users.UserDAO;
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
	public void addUser(User u) {
		UserDAO dao = UserDAO.getInstance();
		dao.addUser(u);
	}

	@Override
	public void editUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(UserVO u) {
		String name = u.getUser();
		String password = u.getPassword();
		boolean admin = u.isAdmin();
		User toReturn = new User(name,password,admin);
		return toReturn;
	}

	@Override
	public void removeUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<UserVO> allUsers() {
		UserDAO dao = UserDAO.getInstance();
		return null;
	}

	@Override
	public UserVO getUserVO(User u) {
		String username = u.getUsername();
		String pass = u.getPassword();
		boolean isAdmin = u.isAdmin();
		return new UserVO(username,pass,isAdmin);
	}



}
