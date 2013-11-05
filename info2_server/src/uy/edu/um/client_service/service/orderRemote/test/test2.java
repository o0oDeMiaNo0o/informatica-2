package uy.edu.um.client_service.service.orderRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public class test2 {
	public static void main(String[] args){
		//managers
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(5);
		ArrayList<OrderVO> allOrders1 = new ArrayList<OrderVO>(10);
		ArrayList<OrderVO> allOrders2 = new ArrayList<OrderVO>(10);
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		allTables = tMgt.allTables();
		TableVO t1 = allTables.get(2);
		TableVO t2 = allTables.get(1);
		Table tGet = tMgt.getTable(t1);
		Table tGet2 = tMgt.getTable(t2);
		allOrders1 = oMgt.getOrderTable(tGet);
		allOrders2 = oMgt.getOrderTable(tGet2);
		System.out.println(allOrders2.get(0).getEspecificaciones());

		int v = 34;
	}
}

