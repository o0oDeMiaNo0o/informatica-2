package uy.edu.um.client_service.business.users.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.user.UserVO;

public interface UserMgt {

	public void addUser(User u) throws NoDatabaseConnection;

	public User getUser(UserVO u);

	public void editUser(User u) throws NoDatabaseConnection;

	public void removeUser(User u) throws NoDatabaseConnection;

	public ArrayList<UserVO> allUsers() throws NoDatabaseConnection;

	public UserVO getUserVO(User u);

	public boolean checkLogin(String username,String psw) throws NoDatabaseConnection;

	public boolean checkUsername(String username) throws NoDatabaseConnection;

	public String hashPassword(String password);

	public UserVO getUser(String nombre) throws NoDatabaseConnection;

}
