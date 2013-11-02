package uy.edu.um.client_service.business.users.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.value_object.user.UserVO;

public interface UserMgt {

	public void addUser(User u);

	public User getUser(UserVO u);

	public void editUser(User u);

	public void removeUser(User u);

	public ArrayList<UserVO> allUsers();

	public UserVO getUserVO(User u);

	public boolean checkLogin(String username,String psw);

	public boolean checkUsername(String username);

	public String hashPassword(String password);

}
