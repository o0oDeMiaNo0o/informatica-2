package uy.edu.um.services.bill.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.bill.BillRemoteMgt;
import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.people.waiters.WaiterVO;

public class BillMgr implements BillMgt{

	private static BillMgr instance = null;

	private BillMgr(){}

	public static BillMgt getInstance() {
		if(instance == null){
			instance = new BillMgr();
		}
		return instance;
	}

	@Override
	public void addBillVO(BillVO b) {
		try {

			String sObjectService = "BillRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			BillRemoteMgt oBillRemoteMgt = (BillRemoteMgt) oRegitry
					.lookup(sObjectService);

			oBillRemoteMgt.addBill(b);

			System.out.println("Factura agregada");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}



	}

	@Override
	public BillVO createBillVO(ArrayList<OrderVO> orders, ClientVO c, WaiterVO w) {
		BillVO toReturn = new BillVO(orders,c,w);
		return toReturn;

	}

}

