package uy.edu.um.services.user.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ErrorLoginException;
import uy.edu.um.exceptions.checks.ExisteUsuarioException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.Verificacion;
import uy.edu.um.interfaces.user.UserRemoteMgt;
import uy.edu.um.services.ServiceFacade;
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
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			oUserRemoteMgt.addUser(u);
			System.out.println("usuario agregado");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}

	}

	@Override
	public UserVO createUserVO(String nombre, String password, boolean admin) throws HasBlanksException {
		UserVO u = null;
		if(Verificacion.hasSpaces(nombre)){
			throw new HasBlanksException("el nombre de usuario contiene espacios");
		}if(Verificacion.hasSpaces(password)){
			throw new HasBlanksException("el password tiene espacios");
		}
		u = new UserVO(nombre,password,admin);
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
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
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
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
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
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
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

	@Override
	public void login(String username, String psw) throws ErrorLoginException {
		if(checkLogin(username,psw) == false){
			throw new ErrorLoginException("Usuario y contraseña no coinciden");
		}
	}

	@Override
	public UserVO isUser(String nombre) {
		UserVO toReturn = null;
		// TODO Auto-generated method stub
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			toReturn = oUserRemoteMgt.getUser(nombre);
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public boolean isAdmin(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}
}

