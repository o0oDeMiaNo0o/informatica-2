package uy.edu.um.services.order.tests;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public class test2 {
	public static void main(String[] args) throws NoServerConnectionException {
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(5);
		ArrayList<OrderVO> allOrders1 = new ArrayList<OrderVO>(10);
		ArrayList<OrderVO> allOrders2 = new ArrayList<OrderVO>(10);
		OrderMgt oMgt = ServiceFacade.getInstance().getOrderMgt();
		allOrders1 = oMgt.allOrders();
		int v = 34;
		System.out.println(allOrders1.get(1).getEspecificaciones());
	}
}
