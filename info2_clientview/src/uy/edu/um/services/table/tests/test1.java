package uy.edu.um.services.table.tests;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.value_object.table.TableVO;

public class test1 {
	public static void main(String[] args){
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(10);
		TableMgt tmgt = ServiceFacade.getInstance().getTableMgt();
		allTables = tmgt.allTables();
		TableVO ocupar = allTables.get(1);
		tmgt.setOcupado(ocupar);

	}
}
