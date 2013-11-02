package uy.edu.um.client_service.persistance.DAO.category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public ArrayList<Category> getCategory() {

		try {

			ArrayList<Category> toReturn = new ArrayList<Category>();

			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Categorias");

			while (oResultSet.next()) {

				int nCat = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);

				Category c = new Category(sName,nCat);
				toReturn.add(c);
			}

			oResultSet.close();
			oStatement.close();
			database.closeConnection();
			return toReturn;
		}
			 catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);


		}

	}

	public boolean existeCategory(String nombre){
		boolean check = false;
		try{
			Statement oStatement = database.getConnection().createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Categorias WHERE Nombre = '"+nombre+"';");

			while (oResultSet.next()) {
				check = true;
			}
			oResultSet.close();
			oStatement.close();
			database.closeConnection();
			return check;
		}
		catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);
		}
	}

}




