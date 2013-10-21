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

}
