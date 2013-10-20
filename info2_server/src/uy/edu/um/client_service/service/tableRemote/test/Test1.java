package uy.edu.um.client_service.service.tableRemote.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;

public class Test1 {
	public static void main(String[] args){
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		tMgt.addTable();
	}
}
