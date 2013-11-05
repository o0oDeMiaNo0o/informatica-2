package uy.edu.um.services.order.tests;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public class test2 {
	public static void main(String[] args){
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(5);
		ArrayList<OrderVO> allOrders1 = new ArrayList<OrderVO>(10);
		ArrayList<OrderVO> allOrders2 = new ArrayList<OrderVO>(10);
		OrderMgt oMgt = ServiceFacade.getInstance().getOrderMgt();
		TableMgt tMgt = ServiceFacade.getInstance().getTableMgt();
		allTables = tMgt.allTables();
		TableVO tGet = allTables.get(2);
		TableVO tGet2 = allTables.get(1);
		allOrders1 = oMgt.getOrderTable(tGet);
		allOrders2 = oMgt.getOrderTable(tGet2);


		int v = 34;
	}
}
