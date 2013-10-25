package uy.edu.um.client_service.business.order.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.value_object.oreder.OrderVO;

public class Test {
	public static void main(String[] args){
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();

		ArrayList<OrderVO> toReturn = new ArrayList<OrderVO>(10);

		toReturn = oMgt.allOrders();

		int v =45;
	}
}
