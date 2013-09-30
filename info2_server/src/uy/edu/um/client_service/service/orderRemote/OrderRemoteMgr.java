package uy.edu.um.client_service.service.orderRemote;

import java.rmi.RemoteException;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
import uy.edu.um.value_object.client.ClientVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class OrderRemoteMgr implements OrderRemoteMgt{

	private static OrderRemoteMgr instance = null;

	private OrderRemoteMgr(){};

	public static OrderRemoteMgr getInstance(){
		if(instance==null){
			instance = new OrderRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addOrder(OrderVO order) throws RemoteException {
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
		Order toAdd = oMgt.getOrder(order);
		oMgt.addOrder(toAdd);
	}

	@Override
	public void getOrdersClient(ClientVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
