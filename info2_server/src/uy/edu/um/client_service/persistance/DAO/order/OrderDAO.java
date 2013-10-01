package uy.edu.um.client_service.persistance.DAO.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
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
			ArrayList <Article> articles = orden.getArticles();
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO pedido (idCliente) VALUES ("+orden.getC().getCi()+");");
			
			ResultSet oResultSet = oStatement.executeQuery("SELECT `idPedido` FROM `pedido` where `pedido`.`idCliente` = "+orden.getC().getCi()+";");
			int nroPedido=0;
			
			while(oResultSet.next()){
			nroPedido = oResultSet.getInt(1);
			}
		
			
			for(int i =0;i<articles.size();i++){
				oStatement.execute("INSERT INTO `Pedido/Producto` (idPedido, idArticle, Nombre) VALUES ("+nroPedido+","+articles.get(i).getProdN()+",'"+articles.get(i).getNombre()+"');");
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
