package uy.edu.um.services.user.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ErrorLoginException;
import uy.edu.um.exceptions.checks.ExisteUsuarioException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.user.UserVO;

public interface UserMgt {

	public void addUser(UserVO a) throws NoServerConnectionException;

	public UserVO createUserVO(String nombre, String password, boolean admin) throws HasBlanksException;

	public void searchUser(String nombre) throws NoServerConnectionException;

	public ArrayList<UserVO> allUsers() throws NoServerConnectionException;

	public void login(String username, String psw) throws ErrorLoginException,NoServerConnectionException;

	public boolean checkLogin(String username, String psw) throws NoServerConnectionException;

	public void checkUsername(String username) throws ExisteUsuarioException,NoServerConnectionException;

	public boolean isAdmin(String nombre) throws NoServerConnectionException;

	public UserVO isUser(String nombre) throws NoServerConnectionException;

	public void editUserVO(UserVO u) throws NoServerConnectionException, NoDatabaseConnection;

	public void removeUserVO(UserVO u) throws NoServerConnectionException, NoDatabaseConnection;

}
