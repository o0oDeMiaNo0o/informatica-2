package uy.edu.um.client_service.business.table.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.client_service.persistance.DAO.mesas.TableDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
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
		TableDAO dao = TableDAO.getInstance();
		dao.addTable();

	}

	@Override
	public void closeTable(Table t) {
		TableDAO dao = TableDAO.getInstance();
		dao.setOcupada(t);

	}

	@Override
	public Table getTable(TableVO t) {
		return new Table(t.getNumero());
	}

	@Override
	public void openTable(Table t) {
		TableDAO dao = TableDAO.getInstance();
		dao.setLibre(t);
	}

	@Override
	public ArrayList<TableVO> allTables() throws NoDatabaseConnection {
		TableDAO dao = TableDAO.getInstance();
		ArrayList<Table> tables = dao.EstadosMesas();
		ArrayList<TableVO> toReturn = new ArrayList<TableVO>(10);
		for(Table t : tables){
			if(t != null){
				TableVO toAdd = this.getTableVO(t);
				toReturn.add(toAdd);
			}
		}
		return toReturn;
	}

	@Override
	public TableVO getTableVO(Table t) {
		int numero = t.getNumero();
		boolean estado = t.isOcuapdo();
		return new TableVO(numero,estado);
	}

	@Override
	public void setOcupado(Table t) {
		TableDAO dao = TableDAO.getInstance();
		dao.setOcupada(t);
	}

	@Override
	public void removeTable(Table t) {
		TableDAO dao = TableDAO.getInstance();

	}

	@Override
	public void setLibre(Table t) {
		TableDAO dao = TableDAO.getInstance();
		dao.setLibre(t);
	}


}
