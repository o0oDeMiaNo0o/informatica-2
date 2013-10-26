package uy.edu.um.client_service.business.bill.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.bill.interfaces.BillMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.business.people.waiters.entities.Waiter;
import uy.edu.um.client_service.business.people.waiters.interfaces.WaiterMgt;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
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
		//managers
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		WaiterMgt wMgt = BusinessFacade.getInstance().getWaiterMgt();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();

		ArrayList<OrderVO> orderVO = b.getOrders();
		ArrayList<Order> orders = new ArrayList<Order>(10);
		for(OrderVO o : orderVO){
			if(o != null){
				Order toAdd = oMgt.getOrder(o);
				orders.add(toAdd);
			}
		}
		Table tAdd = tMgt.getTable(b.getTable());
		Waiter wAdd = wMgt.getWaiter(b.getWaiter());
		Client cAdd = cMgt.getClient(b.getClient());

		Bill toReturn = new Bill(orders,cAdd,tAdd,wAdd);
		return toReturn;
	}

}
