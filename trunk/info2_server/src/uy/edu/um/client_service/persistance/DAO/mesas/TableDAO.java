package uy.edu.um.client_service.persistance.DAO.mesas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;


public class TableDAO {

	private static TableDAO instance = null;
	
	public static TableDAO getInstance(){
		if (instance == null){
			instance = new TableDAO();
		}
		return instance;
	}

	public void addTable() throws NoDatabaseConnection{
		Connection con =null;

		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("INSERT INTO Mesa (Estado) VALUES (DEFAULT);");
			oStatement.close();
			//Verificacion por consola
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}


	}

	public void setOcupada(Table mesa) throws NoDatabaseConnection{
		Connection con = null;
		try{
		con = DatabaseConnectionMgr.getInstance().getConnection();
		Statement oStatement = con.createStatement();
		oStatement.execute("UPDATE MESA set Estado = 'Ocupado' WHERE Mesa.idMesa = "+mesa.getNumero()+";");
		oStatement.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
	}
	
	public void deleteMesa(Table mesa) throws NoDatabaseConnection{
		Connection con =  null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("UPDATE MESA set Estado = 'Eliminada' Where Mesa.idMesa = "+mesa.getNumero()+";");
			oStatement.close();
			
		}
		catch(SQLException e){
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
	}

	public void setLibre(Table mesa) throws NoDatabaseConnection{
		Connection con=null;
		try{
		con = DatabaseConnectionMgr.getInstance().getConnection();
		Statement oStatement = con.createStatement();
		oStatement.execute("UPDATE MESA set Estado='Libre' WHERE idMesa = "+mesa.getNumero()+";");
		oStatement.close();
		System.out.println("Mesa "+mesa.getNumero()+", esta libre");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
	}

	public ArrayList<Table> EstadosMesas() throws NoDatabaseConnection{

	ArrayList<Table> mesas = new ArrayList<Table>();
	Connection con = null;
	try{
		con = DatabaseConnectionMgr.getInstance().getConnection();
		Statement oStatement = con.createStatement();
		ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Mesa Where Estado <> 'Eliminada';");
		while (oResultSet.next()) {
			boolean oc=false;
			int nid = oResultSet.getInt(1);
			String sOcupa = oResultSet.getString(2);
			if(sOcupa.equals("Ocupado")){
				oc=true;
			}
			Table t = new Table(nid,oc);
			mesas.add(t);
		}
		oResultSet.close();
		oStatement.close();
		}
		catch(SQLException e){
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
			}
		}

	return mesas;


}

	public Table searchTable(int id, Connection oConnection) throws NoDatabaseConnection{
	Table result = null;
	try {
		Statement oStatement = oConnection.createStatement();
		ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Mesa` where `Mesa`.`idMesa` = "+id+";");
		while(oResultSet.next()){
			boolean oc=false;
			int nId = oResultSet.getInt(1);
			String sEstado = oResultSet.getString(2);

			if(sEstado.equals("Ocupado")){
				oc=true;
			}

			result = new Table(nId,oc);
		}
		oResultSet.close();
		oStatement.close();
	}
	catch (SQLException e) {
		throw new NoDatabaseConnection("No hay conexion con la base de datos");
	}

	return result;
}


}
