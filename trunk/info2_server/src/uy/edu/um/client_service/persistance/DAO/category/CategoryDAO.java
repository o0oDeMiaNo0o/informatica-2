package uy.edu.um.client_service.persistance.DAO.category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;


public class CategoryDAO {

	private static CategoryDAO instance = null;
	private final static Logger log = Logger.getLogger(CategoryDAO.class);

	private CategoryDAO(){};

	public static CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
		}
		return instance;
	}

	public void addCategory(Category c) throws NoDatabaseConnection {
		Connection connection=null;
		log.info("Intento de agregar categoria");
		try{
			connection= DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();
			oStatement.execute("INSERT INTO CATEGORIAS (Nombre) " +
					"VALUES ('"+c.getNombre()+"');");
			oStatement.close();
			log.info("Categoria agregada correctamente");
		}
		catch(SQLException e){
			log.error("Error al agregar categoria");
			throw new NoDatabaseConnection ("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					log.error("Error al cerrar la conexion con la base de datos");
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}
			}
		}


	}

	public ArrayList<Category> getCategory() throws NoDatabaseConnection {
		Connection connection=null;
		log.info("Retirando todas las categorias");
		try {
			ArrayList<Category> toReturn = new ArrayList<Category>();
			connection= DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();

			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Categorias Where Estado = 'Activa';");

			while (oResultSet.next()) {

				int nCat = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);

				Category c = new Category(sName,nCat);
				toReturn.add(c);
			}

			oResultSet.close();
			oStatement.close();
			log.info("Categorias retiradas");
			return toReturn;
		}
		
		catch (SQLException e) {
			log.error("Error al retirar las categorias");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}

			}
		}

	}
	
	public void deleteCategory(Category c) throws NoDatabaseConnection{
		Connection con = null;
		ArticlesDAO a = ArticlesDAO.getInstance();
		log.info("Intentando eliminar categoria");
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement =con.createStatement();
			oStatement.execute("UPDATE CATEGORIAS set Estado='Eliminada' WHERE idCategorias = "+c.getId()+";");
			oStatement.close();
			a.deleteArticlesCategory(c, con);
			log.info("Categoria eliminada");
		}
		catch(SQLException e){
			log.error("Error al eliminar la categoria");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}

		}
		}
		
	}

	public boolean existeCategory(String nombre) throws NoDatabaseConnection {
		boolean check = false;
		Connection connection = null;
		log.info("Chequenado existencia de categoria "+nombre+"");
		try{
			connection= DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Categorias WHERE (Nombre = '"+nombre+"') AND (Estado = 'Activa');");

			while (oResultSet.next()) {
				check = true;
			}
			oResultSet.close();
			oStatement.close();
			return check;
		}
		catch (SQLException e) {
			log.error("Error al chequear la existencia de la categoria");
			throw new NoDatabaseConnection ("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}

		}
		}
	}

}




