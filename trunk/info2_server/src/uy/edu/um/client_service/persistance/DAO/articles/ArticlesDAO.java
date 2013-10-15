package uy.edu.um.client_service.persistance.DAO.articles;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.persistance.JDBC;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

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

//	public ArticleVO searchArticle(int prodnum){
//		ArticleVO result = null;
//		try {
//			Statement oStatement = database.getConnection().createStatement();
//
//
//			ResultSet oResultSet = oStatement.executeQuery("SELECT `PROD_N`,`NAME`,`PRICE` FROM `Articles` where `Articles`.`PROD_N` = "+prodnum+";");
//
//
//
//			while(oResultSet.next()){
//				String sName = oResultSet.getString(1);
//				BigDecimal nPrice = oResultSet.getBigDecimal(2);
//				result = new ArticleVO(sName,nPrice);
//
//			}
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//
//
//	}
//


	@SuppressWarnings("null")
	public ArrayList<ArticleVO> getArticlesVO() {

		try {

			ArrayList<ArticleVO> toReturn = new ArrayList<ArticleVO>(10);

			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				String sName = oResultSet.getString(2);
				BigDecimal nPrice = oResultSet.getBigDecimal(3);
				int id = oResultSet.getInt(4);
				CategoryVO c = getCategoryVO(id);
				ArticleVO a = new ArticleVO(sName,nPrice,c);
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
	
	public CategoryVO getCategoryVO(int catId){
		CategoryVO c=null;
		
		try{
			Statement oStatement = database.getConnection().createStatement();
			ResultSet oResultSet1 = oStatement.executeQuery("SELECT Nombre FROM Categorias WHERE Categorias.idCategorias="+catId+";");
			
			while (oResultSet1.next()){
				String sName = oResultSet1.getString(1);
				c = new CategoryVO(catId,sName);

			}
			
			oResultSet1.close();
			oStatement.close();
			
		}
		catch(SQLException e){
			
		}
		return c;
		
	}
	
	
	
	


	public void getArticles() {

		try {

			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				int nId = oResultSet.getInt(1);
				int nProd = oResultSet.getInt(2);
				String sName = oResultSet.getString(3);
				BigDecimal nPrice = oResultSet.getBigDecimal(4);

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