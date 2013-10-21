package uy.edu.um.client_service.business.people.waiters.managers;

import java.util.ArrayList;
import uy.edu.um.client_service.business.people.waiters.entities.Waiter;
import uy.edu.um.client_service.business.people.waiters.interfaces.WaiterMgt;
import uy.edu.um.value_object.people.waiters.WaiterVO;

public class WaiterMgr implements WaiterMgt{

	private static WaiterMgr instance = null;

	private WaiterMgr(){};

	public static WaiterMgr getInstance(){
		if(instance == null){
			instance = new WaiterMgr();
		}
		return instance;
	}

	@Override
	public void addWaiter(Waiter w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editWaiter(Waiter w) {
		// TODO Auto-generated method stub

	}

	@Override
	public Waiter getWaiter(WaiterVO w) {
		String nombre = w.getNombre();
		String apellido = w.getApellido();
		String direccion = w.getDireccion();
		String email = w.getEmail();
		int tel = w.getTel();
		int ci = w.getCi();
		Waiter toReturn = new Waiter(nombre,apellido,ci,tel,direccion,email);
		return toReturn;
	}

	@Override
	public void removeWaiter(Waiter w) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<WaiterVO> allWaiters() {
		// TODO Auto-generated method stub
		return null;
	}

}
