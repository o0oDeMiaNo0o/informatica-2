package uy.edu.um.client_service.business.table.managers;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.value_object.table.TableVO;

public class TableMgr implements TableMgt{

	private static TableMgr instance = null;

	private TableMgr(){}

	public static TableMgr getInstance(){
		if(instance == null){
			instance = new TableMgr();
		}
		return instance;
	}
	@Override
	public void addOrderToTable(Table t, Order o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeTable(Table t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Table getTable(TableVO t) {
		return new Table(t.getNumero());
	}

	@Override
	public void openTable(Table t) {
		// TODO Auto-generated method stub

	}

}
