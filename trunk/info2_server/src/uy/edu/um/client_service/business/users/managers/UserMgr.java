package uy.edu.um.client_service.business.users.managers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.client_service.persistance.DAO.users.UserDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
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
	public void addUser(User u) throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		String crypted = this.hashPassword(u.getPassword());
		User uNew = new User(u.getUsername(),crypted,u.isAdmin());
		dao.addUser(uNew);
	}

	@Override
	public void editUser(User u) throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		String crypted = this.hashPassword(u.getPassword());
		User uNew = new User(u.getUsername(),crypted,u.isAdmin());
		dao.editUser(uNew);
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
	public void removeUser(User u) throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		String crypted = this.hashPassword(u.getPassword());
		User uNew = new User(u.getUsername(),crypted,u.isAdmin());
		dao.deleteUser(uNew);
	}

	@Override
	public ArrayList<UserVO> allUsers() throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		ArrayList<UserVO> toReturn = new ArrayList<UserVO>(10);
		ArrayList<User> users = dao.allUsers();
		for(User u : users){
			if(u!=null){
				UserVO uAdd = this.getUserVO(u);
				toReturn.add(uAdd);
			}
		}
		return toReturn;
	}

	@Override
	public UserVO getUserVO(User u) {
		String username = u.getUsername();
		String pass = u.getPassword();
		boolean isAdmin = u.isAdmin();
		return new UserVO(username,pass,isAdmin);
	}

	@Override
	public boolean checkLogin(String username, String psw) throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		String crypted = this.hashPassword(psw);
		return dao.checklogin(username, crypted);
	}

	@Override
	public boolean checkUsername(String username) throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		return dao.checkUsername(username);
	}

	//metodos de la clase
	public String hashPassword(String password) {
		String hashword = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			hashword = hash.toString(16);
		} catch (NoSuchAlgorithmException nsae) {
			// ignore
		}
		return hashword;
	}

	@Override
	public UserVO getUser(String nombre) throws NoDatabaseConnection {
		UserDAO dao = UserDAO.getInstance();
		User obtenido = dao.searchUser(nombre);
		return this.getUserVO(obtenido);
	}
}
