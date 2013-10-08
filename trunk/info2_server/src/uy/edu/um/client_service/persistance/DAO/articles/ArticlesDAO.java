package uy.edu.um.client_service.persistance.DAO.articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.persistance.JDBC;
import uy.edu.um.value_object.article.ArticleVO;

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

	public ArticleVO searchArticle(int prodnum){
		ArticleVO result = null;
		try {
			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT `PROD_N`,`NAME`,`PRICE` FROM `Articles` where `Articles`.`PROD_N` = "+prodnum+";");



			while(oResultSet.next()){
				int nProd = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				int nPrice = oResultSet.getInt(3);
				result = new ArticleVO(nProd,sName,nPrice);

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;


	}

	public void addArticle(Article articulo){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO ARTICLES (PROD_N, NAME, PRICE) " +
					"VALUES ("+articulo.getProdN()+",'"+articulo.getNombre()+"',"+articulo.getPrecio()+");");
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

	@SuppressWarnings("null")
	public ArrayList<ArticleVO> getArticlesVO() {

		try {

			ArrayList<ArticleVO> toReturn = new ArrayList<ArticleVO>(10);

			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				//int nId = oResultSet.getInt(1);
				int nProd = oResultSet.getInt(2);
				String sName = oResultSet.getString(3);
				int nPrice = oResultSet.getInt(4);
				ArticleVO a = new ArticleVO(nProd,sName,nPrice);
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