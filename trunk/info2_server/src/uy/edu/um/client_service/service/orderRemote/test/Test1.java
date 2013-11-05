package uy.edu.um.client_service.service.orderRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.value_object.oreder.OrderVO;

public class Test1 {
	public static void main(String[] args){
		OrderMgt omgt = BusinessFacade.getInstance().getOrderMgt();
		ArrayList<OrderVO> orders = new ArrayList<OrderVO>(10);
		orders = omgt.allOrders();
		int b = 45;
	}
}
