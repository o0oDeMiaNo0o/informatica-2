package uy.edu.um.services.bill.managers;

import java.util.ArrayList;

import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

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
	public BillVO createBillVO(ArrayList<OrderVO> orders, TableVO t) {
		return new BillVO(orders,t);
	}

	@Override
	public void sendBillVO(BillVO b) {

	}
}

