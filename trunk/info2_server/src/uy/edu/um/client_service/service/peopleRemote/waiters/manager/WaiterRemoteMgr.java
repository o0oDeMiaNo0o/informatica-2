package uy.edu.um.client_service.service.peopleRemote.waiters.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.people.waiters.entities.Waiter;
import uy.edu.um.client_service.business.people.waiters.interfaces.WaiterMgt;
import uy.edu.um.interfaces.people.waiters.WaiterRemoteMgt;
import uy.edu.um.value_object.people.waiters.WaiterVO;

public class WaiterRemoteMgr implements WaiterRemoteMgt{

	private static WaiterRemoteMgr instance = null;

	private WaiterRemoteMgr(){}

	public static WaiterRemoteMgr getInstance(){
		if(instance == null){
			instance = new WaiterRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addWaiter(WaiterVO w) throws RemoteException {
		WaiterMgt wMgt = BusinessFacade.getInstance().getWaiterMgt();
		Waiter toAdd = wMgt.getWaiter(w);
		wMgt.addWaiter(toAdd);


	}

	@Override
	public void editWaiter(WaiterVO w) throws RemoteException {
		WaiterMgt wMgt = BusinessFacade.getInstance().getWaiterMgt();
		Waiter toEdit = wMgt.getWaiter(w);
		wMgt.editWaiter(toEdit);

	}

	@Override
	public void removeWaiter(WaiterVO w) throws RemoteException {
		WaiterMgt wMgt = BusinessFacade.getInstance().getWaiterMgt();
		Waiter toRemove = wMgt.getWaiter(w);
		wMgt.removeWaiter(toRemove);

	}

	@Override
	public void showWaiter(WaiterVO w) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<WaiterVO> allWaiters() throws RemoteException {
		WaiterMgt wMgt = BusinessFacade.getInstance().getWaiterMgt();
		return wMgt.allWaiters();
	}

}
