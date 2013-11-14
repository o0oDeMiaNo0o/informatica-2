package uy.edu.um.client_service.persistance.DAO.category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;


public class CategoryDAO {

	private static CategoryDAO instance = null;
	Connection connection = null;

	private CategoryDAO(){};

	public static CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
		}
		return instance;
	}

	public void addCategory(Category c) throws NoDatabaseConnection {
		try{
			 Connection connection= DatabaseConnectionMgr.getInstance().getConnection();

			Statement oStatement = connection.createStatement();
			oStatement.execute("INSERT INTO CATEGORIAS (Nombre) " +
					"VALUES ('"+c.getNombre()+"');");
			oStatement.close();
			//Verificacion por consola
			System.out.println("Categoria agregada correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}
			}
		}


	}

	public ArrayList<Category> getCategory() throws NoDatabaseConnection {

		try {
			ArrayList<Category> toReturn = new ArrayList<Category>();
			Connection connection= DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();

			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Categorias");

			while (oResultSet.next()) {

				int nCat = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);

				Category c = new Category(sName,nCat);
				toReturn.add(c);
			}

			oResultSet.close();
			oStatement.close();
			return toReturn;
		}
		catch (SQLException e) {
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}

			}
		}

	}

	public boolean existeCategory(String nombre) throws NoDatabaseConnection {
		boolean check = false;
		try{
			 Connection connection= DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Categorias WHERE Nombre = '"+nombre+"';");

			while (oResultSet.next()) {
				check = true;
			}
			oResultSet.close();
			oStatement.close();
			return check;
		}
		catch (SQLException e) {
			throw new NoDatabaseConnection ("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}

		}
		}
	}

}




