package uy.edu.um.client_service.service.orderRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public class Test1 {
	public static void main(String[] args) throws NoDatabaseConnection{
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
		ArrayList<OrderVO> allOrders = new ArrayList<OrderVO>(10);
		allOrders = oMgt.allOrders();
		int v = 45;
	}
}
