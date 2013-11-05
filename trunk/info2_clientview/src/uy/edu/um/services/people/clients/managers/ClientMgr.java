package uy.edu.um.services.people.clients.managers;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteClientException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.HasNumberException;
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
					throws ExisteClientException, HasBlanksException, HasNumberException {
		if(existeCliente(nombre,ci) == true){
			throw new ExisteClientException("El cliente "+nombre+" "+apellido+" ya existe");
		}
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
	public void addClientVO(ClientVO c) {
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
			ClientRemoteMgt oArticleRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);
			oArticleRemoteMgt.addClient(c);
			System.out.println("Cliente agregado");
			} catch (Exception e) {
				System.err.println("error:");
				e.printStackTrace();
			}
	}

	@Override
	public void getClient(int ci) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<ClientVO> allClients() {
		ArrayList<ClientVO> array = new ArrayList<ClientVO>(10);
		try {

			String sObjectService = "ClientRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);

			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);

			array = oClientRemoteMgt.allClients();

			} catch (Exception e) {
				System.err.println("error:");
				e.printStackTrace();
			}

		return array;

	}

	@Override
	public void editClientVO(ClientVO c) {
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
			ClientRemoteMgt oArticleRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);
			oArticleRemoteMgt.addClient(c);
			} catch (Exception e) {
				System.err.println("error:");
				e.printStackTrace();
			}
	}

	@Override
	public void removeClientVO(ClientVO c) {
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
					.lookup(sObjectService);
			oClientRemoteMgt.removeClient(c);
			//System.out.println("Cliente agregado");
			} catch (Exception e) {
				System.err.println("error:");
				e.printStackTrace();
			}
	}

	@Override
	public boolean existeCliente(String nombre, int ci){
		boolean check = false;
		try {
			String sObjectService = "ClientRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),1099);
			ClientRemoteMgt oClientRemoteMgt = (ClientRemoteMgt) oRegitry
			.lookup(sObjectService);
			check = oClientRemoteMgt.existeCliente(nombre,ci);
			//System.out.println("Cliente agregado");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return check;
	}



}
