package uy.edu.um.services.table.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.table.TableRemoteMgt;
import uy.edu.um.services.table.interfaces.TableMgt;

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
	public void addTable() {
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.addTable();

			System.out.println("mesa agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}


}
