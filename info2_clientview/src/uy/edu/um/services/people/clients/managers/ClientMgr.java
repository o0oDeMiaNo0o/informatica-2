package uy.edu.um.services.people.clients.managers;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteClientException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.HasNumberException;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.exceptions.checks.Verificacion;
import uy.edu.um.interfaces.people.clients.ClientRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class ClientMgr implements ClientMgt{

	private static ClientMgr instance = null;

	private ClientMgr(){};

	public static ClientMgr getInstance(){
		if(instance == null){
			instance = new ClientMgr();
		}
		return instance;
	}

	@Override
	public ClientVO createClientVO(String nombre, String apellido, int ci,
			int tel, String direccion, String mail, BigDecimal descuento)
					throws HasBlanksException, HasNumberException, NoServerConnectionException, NoDatabaseConnection {
		if(Verificacion.hasNumbers(nombre)){
			throw new HasNumberException("El nombre contiene numeros");
		}
		if(Verificacion.hasNumbers(apellido)){
			throw new HasBlanksException("El apellido contiene numeros");
		}
		ClientVO toReturn = new ClientVO(nombre,apellido,ci,tel,direccion,mail,descuento);
		return toReturn;
	}

	@Override
	public void addClientVO(ClientVO c) throws NoServerConnectionException, NoDatabaseConnection, NoDatabaseConnection{
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			ClientRemoteMgt oArticleRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);
			oArticleRemoteMgt.addClient(c);
		} catch (RemoteException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		} catch (NotBoundException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
	}

	@Override
	public void getClient(int ci) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<ClientVO> allClients() throws NoServerConnectionException, NoDatabaseConnection{
		ArrayList<ClientVO> array = new ArrayList<ClientVO>(10);
		try {

			String sObjectService = "ClientRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);

			array = oClientRemoteMgt.allClients();
		} catch (RemoteException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					" y abrirlo nuevamente");
		} catch (NotBoundException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			" y abrirlo nuevamente");
		}

		return array;

	}

	@Override
	public void editClient(ClientVO c) throws NoServerConnectionException, NoDatabaseConnection {
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);
			oClientRemoteMgt.editClient(c);
			} catch (RemoteException e) {
				throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
						" y abrirlo nuevamente");
			} catch (NotBoundException e) {
				throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
				" y abrirlo nuevamente");
			}
	}

	@Override
	public void removeClientVO(ClientVO c) throws NoServerConnectionException, NoDatabaseConnection{
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);
			oClientRemoteMgt.removeClient(c);
		} catch (RemoteException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		} catch (NotBoundException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
	}

	@Override
	public boolean existeCliente(String nombre, int ci) throws NoServerConnectionException, NoDatabaseConnection{
		boolean check = false;
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
			.lookup(sObjectService);
			check = oClientRemoteMgt.existeCliente(nombre,ci);
		} catch (RemoteException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		} catch (NotBoundException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
		return check;
	}

	@Override
	public ClientVO createClientVO(int id, String nombre, String apellido,
			int ci, int tel, String direccion, String mail, BigDecimal descuento)
			throws HasBlanksException, HasNumberException,
			NoServerConnectionException, NoDatabaseConnection {
		ClientVO toReturn = new ClientVO(id,ci,nombre,apellido,tel,direccion,mail,descuento);
		return toReturn;
	}



}
