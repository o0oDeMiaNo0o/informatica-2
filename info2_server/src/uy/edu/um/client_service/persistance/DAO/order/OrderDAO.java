package uy.edu.um.client_service.persistance.DAO.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.JDBC;
import uy.edu.um.client_service.persistance.DAO.articleOrderDAO.ArticleOrderDAO;
import uy.edu.um.client_service.persistance.DAO.mesas.TableDAO;
import uy.edu.um.client_service.persistance.DAO.users.UserDAO;

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
	
	public void ordenEntregada(Order o){
		
		try {
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("UPDATE Pedido SET `Estado` = 'Entregado' WHERE Pedido.idpedido="+o.getId()+";");
			oStatement.close();
			database.closeConnection();
			// Consola
			System.out.println("El pedido "+o.getId()+" esta terminado.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Order> getOrders() {
		ArrayList<Order> toReturn = new ArrayList<Order>();
		ArticleOrderDAO aOdao =ArticleOrderDAO.getInstance();
		TableDAO tDAO = TableDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		
		try {
			Statement oStatement = database.getConnection().createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Pedido");

			while (oResultSet.next()) {
				boolean e=false;
				int nid = oResultSet.getInt(1);
				Date date = oResultSet.getTimestamp(2);
				int nIdmesa = oResultSet.getInt(3);
				String sEstado = oResultSet.getString(4);
				String sUsername = oResultSet.getString(6);
				ArrayList<ArticleOrder> articles = aOdao.getArticleOrder(nid);
				Table t = tDAO.searchTable(nIdmesa);
				User u = uDAO.searchUser(sUsername);
				
				if(sEstado.equals("Entregado")){
					e=true;
				}
				Order a = new Order(nid,articles,t,u,e,date);
				toReturn.add(a);
			}

			oResultSet.close();
			oStatement.close();
			database.closeConnection();
		}
			 catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);
		}
		return toReturn;


	}
	
	
	
	

}
