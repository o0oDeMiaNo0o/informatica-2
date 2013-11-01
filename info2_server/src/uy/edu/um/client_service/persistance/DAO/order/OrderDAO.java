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
			oStatement.execute("INSERT INTO pedido (Mesa_idMesa,Users_Username,Especificaciones) VALUES ("+orden.getTable().getNumero()+",'"+orden.getUser().getUsername()+"','"+orden.getSpec()+"');");
		

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
	
	public void cambioEstadoOrder(Order o){
		try {
			String estado=defEstado(o.getEstado());
			
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("UPDATE Pedido SET `Estado` = '"+estado+"' WHERE Pedido.idpedido="+o.getId()+";");
			oStatement.close();
			database.closeConnection();
			// Consola
			System.out.println("El pedido "+o.getId()+" esta "+estado+".");
			
		} catch (SQLException e) {
			e.printStackTrace();
			database.closeConnection();
			
		}
		
		
	}
	
	// Esto hay que ver, porque para mostrar las ordenes a la cocina solo me importarian las "En preparacion" o algo de eso
	
	public ArrayList<Order> getOrders() {
		ArrayList<Order> toReturn = new ArrayList<Order>();
		ArticleOrderDAO aOdao =ArticleOrderDAO.getInstance();
		TableDAO tDAO = TableDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		
		try {
			Statement oStatement = database.getConnection().createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Pedido");

			while (oResultSet.next()) {
				int nid = oResultSet.getInt(1);
				Date date = oResultSet.getTimestamp(2);
				int nIdmesa = oResultSet.getInt(3);
				String sEstado = oResultSet.getString(4);
				String sUsername = oResultSet.getString(6);
				ArrayList<ArticleOrder> articles = aOdao.getArticleOrder(nid);
				Table t = tDAO.searchTable(nIdmesa);
				User u = uDAO.searchUser(sUsername);
				
				int estado=defEstado(sEstado);
				
				Order a = new Order(nid,articles,t,u,estado,date);
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
	
	public int defEstado(String e){
		int estado = 0;
		if(e.equals("En Preparacion")){
			estado = 0;
		}
		else if(e.equals("Entregado")){
			estado = 1;
		}
		else if(e.equals("Rechazado")){
			estado = 2;
		}
		else if(e.equals("Delivery")){
			estado = 3;
		}
		return estado;
	}
	
	public String defEstado(int e){
		String estado=null;
		switch(e){
		case 0: estado="En Preparacion"; 
			break;
		case 1: estado="Entregado";
			break;
		case 2: estado="Rechazado";
			break;
		
		default:
			estado=null;
			break;
		}
		return estado;
		}
		
	}
	

