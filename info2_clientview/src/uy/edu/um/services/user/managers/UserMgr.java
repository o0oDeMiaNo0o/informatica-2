package uy.edu.um.services.user.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ErrorLoginException;
import uy.edu.um.exceptions.checks.ExisteUsuarioException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
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
	public void addUser(UserVO u) throws NoServerConnectionException {
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			oUserRemoteMgt.addUser(u);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
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
	public ArrayList<UserVO> allUsers() throws NoServerConnectionException{
		ArrayList<UserVO> array = new ArrayList<UserVO>(10);
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry
					.lookup(sObjectService);
			array = oUserRemoteMgt.allUsers();
			} catch (Exception e) {
				throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
							"y abrirlo nuevamente");
			}
		return array;
	}

	@Override
	public boolean checkLogin(String username, String psw)throws NoServerConnectionException {
		boolean toReturn = false;
		// TODO Auto-generated method stub
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			toReturn = oUserRemoteMgt.checkLogin(username,psw);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
						"y abrirlo nuevamente");
		}
		return toReturn;
	}

	@Override
	public void checkUsername(String username) throws ExisteUsuarioException, NoServerConnectionException{
		boolean toReturn = false;
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			toReturn = oUserRemoteMgt.checkUsername(username);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
						"y abrirlo nuevamente");
		}
		if(toReturn == true){
			throw new ExisteUsuarioException("Ya existe un usuario con el nombre "+username);
		}
	}

	@Override
	public void login(String username, String psw) throws ErrorLoginException, NoServerConnectionException {
		if(checkLogin(username,psw) == false){
			throw new ErrorLoginException("Usuario y contraseña no coinciden");
		}
	}

	@Override
	public UserVO isUser(String nombre) throws NoServerConnectionException {
		UserVO toReturn = null;
		// TODO Auto-generated method stub
		try {
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			toReturn = oUserRemoteMgt.getUser(nombre);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
						"y abrirlo nuevamente");
		}
		return toReturn;
	}

	@Override
	public boolean isAdmin(String nombre) throws NoServerConnectionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void editUserVO(UserVO u) throws NoServerConnectionException,
	NoDatabaseConnection {
		try{
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			oUserRemoteMgt.editUser(u);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}

	}

	@Override
	public void removeUserVO(UserVO u) throws NoServerConnectionException,
			NoDatabaseConnection {
		try{
			String sObjectService = "UserRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);
			oUserRemoteMgt.editUser(u);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}

	}
}

