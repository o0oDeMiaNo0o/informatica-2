package uy.edu.um.client_service.persistance.DAO.mesas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.persistance.JDBC;


public class TableDAO {
	
	private static TableDAO instance = null;
	JDBC database = JDBC.getInstance();
	
	public static TableDAO getInstance(){
		if (instance == null){
			instance = new TableDAO();
		}
		return instance;
	}
	
	public void addTable(){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO Mesa (Estado) VALUES (DEFAULT);");
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			System.out.println("Mesa agregada correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}
	
	public void setOcupada(Table mesa){
		
		try{
		Statement oStatement = database.getConnection().createStatement();
		oStatement.execute("UPDATE MESA set Estado = 'Ocupado' WHERE Mesa.idMesa = "+mesa.getNumero()+";");
		oStatement.close();
		database.closeConnection();
		System.out.println("Mesa "+mesa.getNumero()+", esta ocupada");
		
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}
	}
	
public void setLibre(Table mesa){
		
		try{
		Statement oStatement = database.getConnection().createStatement();
		oStatement.execute("UPDATE MESA set Estado='Libre' WHERE idMesa = "+mesa.getNumero()+";");
		oStatement.close();
		database.closeConnection();
		System.out.println("Mesa "+mesa.getNumero()+", esta libre");
		
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}
	}

public ArrayList<Table> EstadosMesas(){
	
	ArrayList<Table> mesas = new ArrayList<Table>();
	
	try{
		Statement oStatement = database.getConnection().createStatement();
		ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Mesa");		
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
		
		
		oStatement.close();
		database.closeConnection();
		
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}
	
	return mesas;
	
	
}


}
