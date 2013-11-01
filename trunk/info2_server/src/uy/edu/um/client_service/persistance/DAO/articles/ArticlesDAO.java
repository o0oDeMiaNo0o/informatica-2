package uy.edu.um.client_service.persistance.DAO.articles;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.JDBC;

public class ArticlesDAO {

	private static ArticlesDAO instance = null;

	JDBC database = JDBC.getInstance();

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

	public void addArticle(Article articulo){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO ARTICLES ( NAME, PRICE, Categorias_idCategorias) " +
					"VALUES ('"+articulo.getNombre()+"',"+articulo.getPrecio()+","+articulo.getCategory().getId()+");");
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			System.out.println("articulo agregado correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}

	public void deleteArticle(Article articulo){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("UPDATE `info2`.`Articles` SET `Estado` = 'Eliminado' WHERE `ID` = "+articulo.getId()+";");
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			System.out.println("articulo eliminado correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}

	public ArrayList<Article> getArticles() {

		try {

			ArrayList<Article> toReturn = new ArrayList<Article>(10);

			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES WHERE `Estado` = 'Activo'");

			while (oResultSet.next()) {
				
				int nid = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				BigDecimal nPrice = oResultSet.getBigDecimal(3);
				int id = oResultSet.getInt(4);
				Category c = getCategory(id);
				Article a = new Article(nid,sName,nPrice,c);
				toReturn.add(a);
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
	
	
	public void editArticle(Article a){	
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("UPDATE `info2`.`Articles` SET `Estado` = 'Eliminado' WHERE `ID` = "+a.getId()+";");
			oStatement.close();
			database.closeConnection();
			addArticle(a);
			System.out.println("Articulo editado correctamente");
			
		}
		catch(SQLException e){
			database.closeConnection();
			throw new RuntimeException(e);
		}	
		
	}
	
	public Category getCategory(int catId){
		Category c=null;
		
		try{
			Statement oStatement = database.getConnection().createStatement();
			ResultSet oResultSet1 = oStatement.executeQuery("SELECT Nombre FROM Categorias WHERE Categorias.idCategorias="+catId+";");
			
			while (oResultSet1.next()){
				String sName = oResultSet1.getString(1);
				c = new Category(sName,catId);

			}
			
			oResultSet1.close();
			oStatement.close();
			
		}
		catch(SQLException e){
			database.closeConnection();
			throw new RuntimeException(e);
			
		}
		return c;
		
	}
	
	public Article searchArticle(int id){
	Article result = null;
	try {
		Statement oStatement = database.getConnection().createStatement();
		ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Articles` where `Articles`.`ID` = "+id+";");
		
		while(oResultSet.next()){
			String sName = oResultSet.getString(2);
			BigDecimal nPrice = oResultSet.getBigDecimal(3);
			int catID = oResultSet.getInt(4);
			Category c = getCategory(catID);
			
			result = new Article(id,sName,nPrice,c);

		}
		oResultSet.close();
		oStatement.close();


	} catch (SQLException e) {
		database.closeConnection();
		throw new RuntimeException(e);
	}
	return result;


}

}