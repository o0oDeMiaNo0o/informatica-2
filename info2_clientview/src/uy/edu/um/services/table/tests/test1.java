package uy.edu.um.services.table.tests;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;

public class test1 {
	public static void main(String[] args){
		TableMgt tmgt = ServiceFacade.getInstance().getTableMgt();
		tmgt.addTable();

	}
}
