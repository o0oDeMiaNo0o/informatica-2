package uy.edu.um.client_service.persistance.DAO.category;

import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.JDBC;

public class CategoryDAO {

	private static CategoryDAO instance = null;
	JDBC database = JDBC.getInstance();


	private CategoryDAO(){};

	public static CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
		}
		return instance;
	}

	public void addCategory(Category c){
		try{
			
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO CATEGORIAS (Nombre) " +
					"VALUES ('"+c.getNombre()+"');");
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			System.out.println("Categoria agregada correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}
	
	


}




