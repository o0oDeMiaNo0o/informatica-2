package uy.edu.um.services.people.waiters.interfaces;

import uy.edu.um.value_object.people.waiters.WaiterVO;

public interface WaiterMgt {

	public void createWaiterVO(String nombre, String apellido,int ci, int tel, String direccion,
			String mail, boolean trabajando);

	public void sendWaiterVO(WaiterVO w);

}
