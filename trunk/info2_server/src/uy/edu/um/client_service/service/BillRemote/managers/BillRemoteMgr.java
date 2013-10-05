package uy.edu.um.client_service.service.BillRemote.managers;

import java.rmi.RemoteException;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.bill.interfaces.BillMgt;
import uy.edu.um.interfaces.bill.BillRemoteMgt;
import uy.edu.um.value_object.bill.BillVO;

public class BillRemoteMgr implements BillRemoteMgt{

	private static BillRemoteMgr instance = null;

	private BillRemoteMgr(){}

	public static BillRemoteMgr getInstance(){
		if(instance == null){
			instance = new BillRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addBill(BillVO b) throws RemoteException {
		BillMgt bMgt = BusinessFacade.getInstance().getBillMgt();
		Bill toAdd = bMgt.getBill(b);
		bMgt.addBill(toAdd);
		System.out.println("Llego correctamente por RMI");
	}

}
