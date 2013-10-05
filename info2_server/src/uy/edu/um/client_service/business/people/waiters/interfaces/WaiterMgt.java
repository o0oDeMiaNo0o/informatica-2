package uy.edu.um.client_service.business.people.waiters.interfaces;

import uy.edu.um.client_service.business.people.waiters.entities.Waiter;
import uy.edu.um.value_object.people.waiters.WaiterVO;

public interface WaiterMgt {

	public void addWaiter(Waiter w);

	public Waiter getWaiter(WaiterVO w);

	public void removeWaiter(Waiter w);

	public void editWaiter(Waiter w);

}
