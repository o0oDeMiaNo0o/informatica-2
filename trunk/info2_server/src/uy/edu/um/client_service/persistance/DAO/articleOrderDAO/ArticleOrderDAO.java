package uy.edu.um.client_service.persistance.DAO.articleOrderDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;

public class ArticleOrderDAO {
	
	private static ArticleOrderDAO instance = null;
	private Connection con = null;
	public static ArticleOrderDAO getInstance(){
		if (instance == null){
			instance = new ArticleOrderDAO();
		}
		return instance;
	}
	
	public ArticleOrderDAO(){
		
	}
	
	public ArrayList<ArticleOrder> getArticleOrder(int nOrder){
		ArrayList<ArticleOrder> array = new ArrayList<ArticleOrder>();
		ArticlesDAO aDAO = ArticlesDAO.getInstance();
		
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT `Articles_ID`,`Cantidad` FROM `Pedido/Articulos` WHERE pedido_idpedido ="+nOrder+";");

			while (oResultSet.next()) {
				
				int nid = oResultSet.getInt(1);
				int cant = oResultSet.getInt(2);
				Article art = aDAO.searchArticle(nid);
				
				ArticleOrder a = new ArticleOrder(art,cant);
				array.add(a);
			}
			oResultSet.close();
			oStatement.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
			
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
		return array;
		
	}

}
