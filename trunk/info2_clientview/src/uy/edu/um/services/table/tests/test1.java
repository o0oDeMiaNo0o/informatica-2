package uy.edu.um.services.table.tests;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.value_object.table.TableVO;

public class test1 {
	public static void main(String[] args) throws NoServerConnectionException, NoDatabaseConnection{

		ArrayList<TableVO> allTables = new ArrayList<TableVO>(10);
		TableMgt tmgt = ServiceFacade.getInstance().getTableMgt();
		allTables = tmgt.allTables();

		int v =34 ;
	}
}
