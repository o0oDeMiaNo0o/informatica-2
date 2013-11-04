package uy.edu.um.services.people.waiters.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.people.waiters.WaiterVO;

public interface WaiterMgt {

	public WaiterVO createWaiterVO(String nombre, String apellido,int ci, int tel, String direccion,
			String mail);

	public void addWaiterVO(WaiterVO w);

	public void editWaiterVO(WaiterVO w);

	public void removeWaiterVO(WaiterVO w);

	public ArrayList<WaiterVO> allWaiters();

}
