package uy.edu.um.services.table.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.interfaces.table.TableRemoteMgt;
import uy.edu.um.services.ServiceFacade;
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
	public void addTable() throws NoServerConnectionException, NoDatabaseConnection{
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.addTable();

			System.out.println("mesa agregado");

		} catch (Exception e) {
			System.err.println("error:");
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}

	}

	@Override
	public ArrayList<TableVO> allTables() throws NoServerConnectionException, NoDatabaseConnection, NoDatabaseConnection{
		ArrayList<TableVO> toReturn = new ArrayList<TableVO>(10);
		try {
			String sObjectService = "TableRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);
			toReturn = oTableRemoteMgt.allTables();
		} catch (Exception e) {
			System.err.println("error:");
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}
		return toReturn;

	}

	@Override
	public void setOcupado(TableVO t) throws NoServerConnectionException, NoDatabaseConnection{
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.setOcupado(t);

			System.out.println("mesa "+t.getNumero()+" cambio de estado a ocupada");

		} catch (Exception e) {
			System.err.println("error:");
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}


	}

	@Override
	public void removeTable(TableVO t) throws NoServerConnectionException, NoDatabaseConnection {
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.removeTable(t);

		} catch (Exception e) {
			System.err.println("error:");
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}


	}

	@Override
	public void setLibre(TableVO t) throws NoServerConnectionException, NoDatabaseConnection{
		try {

			String sObjectService = "TableRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			TableRemoteMgt oTableRemoteMgt = (TableRemoteMgt) oRegitry
					.lookup(sObjectService);

			oTableRemoteMgt.removeTable(t);

		} catch (Exception e) {
			System.err.println("error:");
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}

	}

}
