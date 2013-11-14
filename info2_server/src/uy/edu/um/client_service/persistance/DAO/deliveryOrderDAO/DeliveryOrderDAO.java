package uy.edu.um.client_service.persistance.DAO.deliveryOrderDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class DeliveryOrderDAO {
	

	private static DeliveryOrderDAO instance = null;
	
	public static DeliveryOrderDAO getInstance(){
		if (instance == null){
			instance = new DeliveryOrderDAO();
		}
		return instance;
	}

	public DeliveryOrderDAO(){

	}

	public ArrayList<ArticleOrder> getDeliveryOrder(int nOrder, Connection oConnection) throws NoDatabaseConnection{
		ArrayList<ArticleOrder> array = new ArrayList<ArticleOrder>();
		ArticlesDAO aDAO = ArticlesDAO.getInstance();
		try{
			Statement oStatement = oConnection.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT `Articles_ID`,`Cantidad` FROM `Delivery/Articulos` WHERE Delivery_idDelivery ="+nOrder+";");

			while (oResultSet.next()) {

				int nid = oResultSet.getInt(1);
				int cant = oResultSet.getInt(2);
				Article art = aDAO.searchArticle(nid, oConnection);
				ArticleOrder a = new ArticleOrder(art,cant);
				array.add(a);
			}
			oResultSet.close();
			oStatement.close();
		}
		catch(SQLException e){
			throw new NoDatabaseConnection("No hay conexion con la base de datos");

		}
		return array;

	}

}
