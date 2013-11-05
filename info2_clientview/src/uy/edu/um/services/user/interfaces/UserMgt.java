package uy.edu.um.services.user.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ErrorLoginException;
import uy.edu.um.exceptions.checks.ExisteUsuarioException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.value_object.user.UserVO;

public interface UserMgt {

	public void addUser(UserVO a);

	public UserVO createUserVO(String nombre, String password, boolean admin) throws HasBlanksException;

	public void searchUser(String nombre);

	public ArrayList<UserVO> allUsers();

	public void login(String username, String psw) throws ErrorLoginException;

	public boolean checkLogin(String username, String psw);

	public void checkUsername(String username) throws ExisteUsuarioException;

	public boolean isAdmin(String nombre);

	public UserVO isUser(String nombre);

}
