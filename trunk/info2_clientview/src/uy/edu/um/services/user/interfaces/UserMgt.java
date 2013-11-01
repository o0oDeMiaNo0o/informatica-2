package uy.edu.um.services.user.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.user.UserVO;

public interface UserMgt {

	public void addUser(UserVO a);

	public UserVO createUserVO(String nombre, String password, boolean admin);

	public void searchUser(String nombre);

	public ArrayList<UserVO> allUsers();

	public boolean checkLogin(String username, String psw);

	public boolean existUsername(String username);

}
