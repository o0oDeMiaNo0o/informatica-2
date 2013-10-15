package uy.edu.um.services.table.managers;

import uy.edu.um.services.table.interfaces.TableMgt;
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
	public void addTable(TableVO t) {
		// TODO Auto-generated method stub

	}

	@Override
	public TableVO createTableVO(int numero) {
		return new TableVO(numero);

	}

}
