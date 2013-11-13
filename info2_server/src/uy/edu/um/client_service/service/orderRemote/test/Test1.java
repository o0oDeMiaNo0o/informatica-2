package uy.edu.um.client_service.service.orderRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.oreder.OrderVO;

public class Test1 {
	public static void main(String[] args) throws NoDatabaseConnection{
		OrderMgt omgt = BusinessFacade.getInstance().getOrderMgt();
		ArrayList<OrderVO> orders = new ArrayList<OrderVO>(10);
		orders = omgt.allOrders();
		System.out.println(orders.get(0).getEspecificaciones());
		int b = 45;
	}
}
