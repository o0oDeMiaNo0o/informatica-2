package uy.edu.um.client_service.persistance.DAO.articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.persistance.JDBC;

public class ArticlesDAO {

	private static ArticlesDAO instance = new ArticlesDAO();

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
			oStatement.execute("INSERT INTO ARTICLES (PROD_N, NAME, PRICE) VALUES ("+articulo.getProdN()+",'"+articulo.getNombre()+"',"+articulo.getPrecio()+");");
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			//System.out.println("articulo agregado correctamente");
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
				int nProd = oResultSet.getInt(2);
				String sName = oResultSet.getString(3);
				int nPrice = oResultSet.getInt(4);

				System.out.println("Article. ID: " + nId +" Product Nr: "+nProd+ " Nombre: " + sName + " Precio: " + nPrice);

			}

			oResultSet.close();
			oStatement.close();
			database.closeConnection();

			
		}
			 catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);

		}



}
}
