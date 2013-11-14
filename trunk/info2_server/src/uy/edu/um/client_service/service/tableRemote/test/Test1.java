package uy.edu.um.client_service.service.tableRemote.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class Test1 {
	public static void main(String[] args) throws NoDatabaseConnection{
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		tMgt.addTable();
	}
}
