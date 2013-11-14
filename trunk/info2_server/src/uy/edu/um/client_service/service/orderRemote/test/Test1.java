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
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(5);
		ArrayList<OrderVO> allOrders1 = new ArrayList<OrderVO>(10);
		//ArrayList<OrderVO> allOrders2 = new ArrayList<OrderVO>(10);
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
//		TableMgt tMgt = ServiceFacade.getInstance().getTableMgt();
		allOrders1 = oMgt.allOrders();
		OrderVO toChange = allOrders1.get(1);
		Order toChange2 = oMgt.getOrder(toChange);
		toChange2.setEstado(2);
		oMgt.rechazado(toChange2);
	}
}
