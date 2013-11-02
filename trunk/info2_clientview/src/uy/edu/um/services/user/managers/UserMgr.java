package uy.edu.um.services.user.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import uy.edu.um.exceptions.Verificacion;
import uy.edu.um.interfaces.user.UserRemoteMgt;
import uy.edu.um.services.exceptions.ExisteUsuarioException;
import uy.edu.um.services.exceptions.HasBlanksException;
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
	public void addUser(UserVO u) {
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			oUserRemoteMgt.addUser(u);
			System.out.println("usuario agregado");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}

	}

	@Override
	public UserVO createUserVO(String nombre, String password, boolean admin) {
		UserVO u = null;
		try{
			checkUsername(nombre);
			checkBlanks(nombre);
			checkBlanks(password);
			u = new UserVO(nombre,password,admin);
			return u;
		}catch(ExisteUsuarioException e){
			e.printStackTrace();
		}catch(HasBlanksException e){
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void searchUser(String nombre) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<UserVO> allUsers() {
		ArrayList<UserVO> array = new ArrayList<UserVO>(10);
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry
					.lookup(sObjectService);
			array = oUserRemoteMgt.allUsers();
			} catch (Exception e) {
				System.err.println("error:");
				e.printStackTrace();
			}
		return array;
	}

	@Override
	public boolean checkLogin(String username, String psw) {
		boolean toReturn = false;
		// TODO Auto-generated method stub
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			toReturn = oUserRemoteMgt.checkLogin(username,psw);
			if(toReturn == true){
				System.out.println("Login aceptado");
			}
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public void checkUsername(String username) throws ExisteUsuarioException{
		boolean toReturn = false;
		// TODO Auto-generated method stub
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			toReturn = oUserRemoteMgt.checkUsername(username);
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		if(toReturn == true){
			throw new ExisteUsuarioException("Ya existe un usuario con el nombre "+username);
		}
	}

	public static void checkBlanks(String s) throws HasBlanksException{
		if(Verificacion.hasSpaces(s)){
			throw new HasBlanksException("la contraseña y/o el nombre de usuario tiene espacios en blanco");
		}
	}
}

