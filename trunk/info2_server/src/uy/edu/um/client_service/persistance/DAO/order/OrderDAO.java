package uy.edu.um.client_service.persistance.DAO.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.persistance.JDBC;

public class OrderDAO {
	
	private static OrderDAO instance = null;
	private JDBC database = JDBC.getInstance();
	
	public static OrderDAO getInstance(){
		if (instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}
	
	public OrderDAO(){
		
	}
	
	public void addOrder(Order orden){
		try{
			ArrayList <ArticleOrder> articles = orden.getArticles();
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO pedido (Mesa_idMesa,Users_Username) VALUES ("+orden.getTable().getNumero()+",'"+orden.getUser().getUsername()+"');");
			int nroPedido=0;
		

			for(int i =0;i<articles.size();i++){
				ResultSet oResultSet1 = oStatement.executeQuery("SELECT ID FROM ARTICLES WHERE ARTICLES.NAME='"+articles.get(i).getArticle().getNombre()+"';");
				int nId= 0;
				while(oResultSet1.next()){
					nId = oResultSet1.getInt(1);
				}
				oStatement.execute("INSERT INTO `Pedido/Articulos` (pedido_idpedido, Articles_ID,Cantidad) VALUES (LAST_INSERT_ID(),"+nId+","+articles.get(i).getCantidad()+");");
			}
			
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			System.out.println("Orden agregada correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}
	
	
	
	

}
