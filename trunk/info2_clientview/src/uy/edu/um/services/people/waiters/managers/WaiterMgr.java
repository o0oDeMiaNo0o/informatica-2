package uy.edu.um.services.people.waiters.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.people.waiters.WaiterRemoteMgt;
import uy.edu.um.services.people.waiters.interfaces.WaiterMgt;
import uy.edu.um.value_object.people.waiters.WaiterVO;

public class WaiterMgr implements WaiterMgt{

	private static WaiterMgr instance = null;

	private WaiterMgr(){}

	public static WaiterMgr getInstance(){
		if(instance == null){
			instance = new WaiterMgr();
		}return instance;
	}

	@Override
	public void createWaiterVO(String nombre, String apellido, int ci, int tel,
			String direccion, String mail, boolean trabajando) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWaiterVO(WaiterVO w) {
		try {

			String sObjectService = "WaiterRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			WaiterRemoteMgt oWaiterRemoteMgt = (WaiterRemoteMgt) oRegitry
					.lookup(sObjectService);

			oWaiterRemoteMgt.addWaiter(w);

			System.out.println("mozo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}

	@Override
	public ArrayList<WaiterVO> allWaiters() {

		return null;
	}

	@Override
	public void editWaiter(WaiterVO w) {
		try {

			String sObjectService = "WaiterRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			WaiterRemoteMgt oWaiterRemoteMgt = (WaiterRemoteMgt) oRegitry
					.lookup(sObjectService);

			oWaiterRemoteMgt.editWaiter(w);

			System.out.println("mozo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}


	}

	@Override
	public void removeWaiter(WaiterVO w) {
		try {

			String sObjectService = "WaiterRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			WaiterRemoteMgt oWaiterRemoteMgt = (WaiterRemoteMgt) oRegitry
					.lookup(sObjectService);

			oWaiterRemoteMgt.removeWaiter(w);

			System.out.println("mozo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}


	}

}
