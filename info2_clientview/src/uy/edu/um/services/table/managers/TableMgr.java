package uy.edu.um.services.table.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.table.TableRemoteMgt;
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

	@Override
	public ArrayList<TableVO> allTables() {

		ArrayList<TableVO> toReturn = new ArrayList<TableVO>(10);

		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			toReturn = oTableRemoteMgt.allTables();

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

		return toReturn;

	}

	@Override
	public void setOcupado(TableVO t) {
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.setOcupado(t);

			System.out.println("mesa "+t.getNumero()+" cambio de estado a ocupada");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}


	}

	@Override
	public void removeTable(TableVO t) {
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.removeTable(t);

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}


	}


}
