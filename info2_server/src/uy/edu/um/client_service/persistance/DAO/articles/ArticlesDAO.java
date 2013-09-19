package uy.edu.um.client_service.persistance.DAO.articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.persistance.JDBC;

public class ArticlesDAO {

	private static ArticlesDAO instance = new ArticlesDAO();

	JDBC database = new JDBC();

	//constructor
	private ArticlesDAO() {
		// TODO Auto-generated constructor stub
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
			oStatement.execute("INSERT INTO ARTICLES VALUES("+articulo.getId()+",'"+articulo.getNombre()+"',"+articulo.getPrecio()+")");
			oStatement.close();
			database.closeConnection();
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}

	}

	public void getArticles() {

		try {

			Statement oStatement = database.getConnection().createStatement();

			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				int nId = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				int nPrice = oResultSet.getInt(3);

				System.out.println("Article. ID: " + nId + " Nombre: " + sName + " Precio: " + nPrice);
				database.closeConnection();
			}

			oResultSet.close();
			oStatement.close();

		} catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);

		}



}
}
