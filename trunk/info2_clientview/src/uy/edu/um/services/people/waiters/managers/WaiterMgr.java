package uy.edu.um.services.people.waiters.managers;

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
	public void sendWaiterVO(WaiterVO w) {
		// TODO Auto-generated method stub

	}

}
