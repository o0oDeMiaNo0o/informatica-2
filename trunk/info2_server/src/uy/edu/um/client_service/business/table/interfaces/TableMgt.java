package uy.edu.um.client_service.business.table.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public ArrayList<TableVO> allTables() throws NoDatabaseConnection;

	public void addTable() throws NoDatabaseConnection;

	public void closeTable(Table t) throws NoDatabaseConnection;

	public void addOrderToTable(Table t, Order o);

	public void openTable(Table t) throws NoDatabaseConnection;

	public Table getTable(TableVO t);

	public TableVO getTableVO(Table t);

	public void removeTable(Table t);

	public void setOcupado(Table t) throws NoDatabaseConnection;

	public void setLibre(Table t) throws NoDatabaseConnection;

}
