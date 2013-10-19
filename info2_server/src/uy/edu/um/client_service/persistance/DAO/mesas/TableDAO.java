package uy.edu.um.client_service.persistance.DAO.mesas;

import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.persistance.JDBC;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;

public class TableDAO {
	
	private static TableDAO instance = null;
	JDBC database = JDBC.getInstance();
	
	public static TableDAO getInstance(){
		if (instance == null){
			instance = new TableDAO();
		}
		return instance;
	}
	
	public void addTable(Table mesa){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO Mesa " +
					"VALUES ("+mesa.getNumero()+",'Libre');");
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


}
