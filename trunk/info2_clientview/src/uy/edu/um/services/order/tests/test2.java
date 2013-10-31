package uy.edu.um.services.order.tests;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.value_object.oreder.OrderVO;

public class test2 {
	public static void main(String[] args){
		ArrayList<OrderVO> allOrders = new ArrayList<OrderVO>(10);
		OrderMgt oMgt = ServiceFacade.getInstance().getOrderMgt();
		allOrders = oMgt.allOrders();
		int v = 34;
	}
}
