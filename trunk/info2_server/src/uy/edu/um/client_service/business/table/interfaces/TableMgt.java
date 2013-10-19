package uy.edu.um.client_service.business.table.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public ArrayList<TableVO> allTables();

	public void addTable();

	public void closeTable(Table t);

	public void addOrderToTable(Table t, Order o);

	public void openTable(Table t);

	public Table getTable(TableVO t);

}
