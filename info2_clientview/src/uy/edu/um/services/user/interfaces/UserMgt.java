package uy.edu.um.services.user.interfaces;

import uy.edu.um.value_object.user.UserVO;

public interface UserMgt {

	public void addUser(UserVO a);

	public UserVO createUserVO(String nombre, String password, boolean admin);

	public void searchUser(String nombre);

}
