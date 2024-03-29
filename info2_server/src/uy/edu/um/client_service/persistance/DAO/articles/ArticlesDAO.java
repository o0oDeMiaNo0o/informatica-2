package uy.edu.um.client_service.persistance.DAO.articles;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import org.apache.log4j.*;

public class ArticlesDAO {

	private static ArticlesDAO instance = null;
	private final static Logger log = Logger.getLogger(ArticlesDAO.class);

	//constructor
	public ArticlesDAO() {

	}

	//obtener instancia
	public static ArticlesDAO getInstance(){
		if (instance == null){
			instance = new ArticlesDAO();
		}
		return instance;
	}

	
	public void addArticle(Article articulo) throws NoDatabaseConnection{
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			addArticle(articulo,con);
		}
		catch(NoDatabaseConnection e){
			throw new NoDatabaseConnection("No hay conexion con la base de datos");	
		} catch (SQLException e) {
			throw new NoDatabaseConnection("No hay conexion con la base de datos");	
		}
		finally{
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		}
		
	}
	
	public void addArticle(Article articulo, Connection con) throws NoDatabaseConnection{
		try{
			log.info("Intento de agregar articulo");
			Statement oStatement =con.createStatement();
			oStatement.execute("INSERT INTO ARTICLES ( NAME, PRICE, Categorias_idCategorias) " +
					"VALUES ('"+articulo.getNombre()+"',"+articulo.getPrecio()+","+articulo.getCategory().getId()+");");
			oStatement.close();
			log.info("Articulo agregado");
		}
		catch(SQLException e){
			log.error("Error al agregar articulo");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		

	}

	public void deleteArticle(Article articulo) throws NoDatabaseConnection{
		Connection con = null;
		try{
			log.info("Intento de borrar articulo");
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("UPDATE `info2`.`Articles` SET `Estado` = 'Eliminado' WHERE `ID` = "+articulo.getId()+";");
			oStatement.close();
			log.info("Articulo Eliminado");
			//Verificacion por consola
		}
		catch(SQLException e){
			log.error("Error al eliminar articulo");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		}

	}

	public ArrayList<Article> getArticles() throws NoDatabaseConnection {
		Connection con = null;
		try {
			
			ArrayList<Article> toReturn = new ArrayList<Article>(10);
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES WHERE `Estado` = 'Activo'");
			while (oResultSet.next()) {
				int nid = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				BigDecimal nPrice = oResultSet.getBigDecimal(3);
				int id = oResultSet.getInt(4);
				Category c = getCategory(id,con);
				Article a = new Article(nid,sName,nPrice,c);
				toReturn.add(a);
			}
			oResultSet.close();
			oStatement.close();
			return toReturn;
		}
		catch (SQLException e) {
			log.error("Error al retirar lista de articulos");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}


	public void editArticle(Article a) throws NoDatabaseConnection{
		Connection con = null;
		try{
			log.info("Intento de editar articulo");
			con = DatabaseConnectionMgr.getInstance().getConnection();
				Statement oStatement = con.createStatement();
				oStatement.execute("UPDATE `info2`.`Articles` SET `Estado` = 'Eliminado' WHERE `ID` = "+a.getId()+";");
				oStatement.close();
				addArticle(a);
				log.info("Articulo editado"); 

		}
		catch(SQLException e){
			log.error("Error al editar el articulo");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		} catch (NoDatabaseConnection e) {
			log.error("Error al editar el articulo");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");

		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al cerrar la conexion a la base de datos");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}

	}
	
	public Category getCategory(int catId) throws NoDatabaseConnection{
		Category c=null;
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet1 = oStatement.executeQuery("SELECT Nombre FROM Categorias WHERE Categorias.idCategorias="+catId+";");
			while (oResultSet1.next()){
				String sName = oResultSet1.getString(1);
				c = new Category(sName,catId);
			}
			oResultSet1.close();
			oStatement.close();

		}
		catch(SQLException e){
			log.error("Error al retirar la categoria");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");

		}
		return c;

	}
	

	public Category getCategory(int catId, Connection con) throws NoDatabaseConnection{
		Category c=null;
		try{
			Statement oStatement = con.createStatement();
			ResultSet oResultSet1 = oStatement.executeQuery("SELECT Nombre FROM Categorias WHERE Categorias.idCategorias="+catId+";");
			while (oResultSet1.next()){
				String sName = oResultSet1.getString(1);
				c = new Category(sName,catId);
			}
			oResultSet1.close();
			oStatement.close();

		}
		catch(SQLException e){
			log.error("Error al retirar la categoria");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");

		}
		return c;

	}

	public Article searchArticle(int id, Connection oConnection) throws NoDatabaseConnection{
		Article result = null;
		try {
			Statement oStatement = oConnection.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Articles` where `Articles`.`ID` = "+id+";");

			while(oResultSet.next()){
				String sName = oResultSet.getString(2);
				BigDecimal nPrice = oResultSet.getBigDecimal(3);
				int catID = oResultSet.getInt(4);
				Category c = getCategory(catID,oConnection);

				result = new Article(id,sName,nPrice,c);

			}
			oResultSet.close();
			oStatement.close();


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	
	public boolean existeArticle(String nombre) throws NoDatabaseConnection{
		Connection con = null;
		boolean b = false;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			b = existeArticle(nombre,con);
			
		}
		catch(NoDatabaseConnection n){
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		} catch (SQLException e) {
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al cerrar la conexion");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
		return b;
	}

	public boolean existeArticle(String nombre, Connection con) throws NoDatabaseConnection{
		boolean result = false;
		try {
			log.info("Chequeando la existencia de un articulo llamado "+nombre+"");
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Articles` where Name = '"+nombre+"' "+
					"and Estado = 'Activo';");

			while(oResultSet.next()){
				result = true;
			}
			oResultSet.close();
			oStatement.close();
			log.info("El articulo existe");
		} catch (SQLException e) {
			log.error("El articulo no existe");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		return result;
	}
	
	public void deleteArticlesCategory(Category c, Connection con) throws NoDatabaseConnection{
		try{
			log.info("Intento de borrar todos los articulos de una categoria");
			Statement oStatement = con.createStatement();
			oStatement.execute("UPDATE `info2`.`Articles` SET `Estado` = 'Eliminado' WHERE `Categorias_idCategorias` = "+c.getId()+";");
			oStatement.close();
			log.info("Articulos de la categoria eliminados");
		}
		catch(SQLException e){
			log.error("Error al borrar los articulos pertenecientes a la categoria"+c.getNombre()+"");
			throw new NoDatabaseConnection("No hay conexion a la base de datos");
		}
		
	}

}