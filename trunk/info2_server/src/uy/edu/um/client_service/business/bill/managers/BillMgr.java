package uy.edu.um.client_service.business.bill.managers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.bill.interfaces.BillMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

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
		//

	}

	@Override
	public Bill getBill(BillVO b) {
		//managers
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
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
		Client cAdd = cMgt.getClient(b.getClient());
		Date date = b.getDate();
		Bill toReturn = new Bill(orders,cAdd,tAdd,date);
		return toReturn;
	}

	@Override
	public BillVO getBillVO(Bill b) {
		//Managers
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();

		ArrayList<Order> orders = b.getOrders();
		ArrayList<OrderVO> oAdd = new ArrayList<OrderVO>(10);
		for(Order o : orders){
			if(o!=null){
				OrderVO oVO = oMgt.getOrderVO(o);
				oAdd.add(oVO);
			}
		}
		TableVO tAdd = tMgt.getTableVO(b.getTable());
		ClientVO cAdd = cMgt.getClientVO(b.getClient());
		BigDecimal montoTotal = b.getMontoTotal();
		Date date = b.getDate();
		BillVO toReturn = new BillVO(oAdd,cAdd,tAdd,montoTotal,date);
		return toReturn;
	}

}
