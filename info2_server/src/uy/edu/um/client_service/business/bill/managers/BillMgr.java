package uy.edu.um.client_service.business.bill.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.bill.interfaces.BillMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class BillMgr implements BillMgt{

	private static BillMgr instance = null;

	private BillMgr(){}

	public static BillMgr getInstance(){
		if(instance == null){
			instance = new BillMgr();
		}
		return instance;
	}

	@Override
	public void addBill(Bill b) {
		// TODO Auto-generated method stub

	}

	@Override
	public Bill getBill(BillVO b) {
		ArrayList<OrderVO> orderVO = b.getOrders();
		ArrayList<Order> orders = new ArrayList<Order>(10);
		for(OrderVO o : orderVO){
			if(o != null){
				OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
				Order toAdd = oMgt.getOrder(o);
				orders.add(toAdd);
			}
		}
		Bill toReturn = new Bill(orders);
		return toReturn;
	}

}
