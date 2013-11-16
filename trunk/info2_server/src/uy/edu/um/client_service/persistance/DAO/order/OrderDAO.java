package uy.edu.um.client_service.persistance.DAO.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.client_service.persistance.DAO.articleOrderDAO.ArticleOrderDAO;
import uy.edu.um.client_service.persistance.DAO.mesas.TableDAO;
import uy.edu.um.client_service.persistance.DAO.users.UserDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class OrderDAO {

	private static OrderDAO instance = null;
	private final static Logger log = Logger.getLogger(OrderDAO.class);
	
	public static OrderDAO getInstance(){
		if (instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}

	public OrderDAO(){

	}

	public void addOrder(Order orden) throws NoDatabaseConnection{
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			ArrayList <ArticleOrder> articles = orden.getArticles();
			Statement oStatement = con.createStatement();
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
			log.info("Orden agregada correctamente");
		}
		catch(SQLException e){
			log.info("Error al agregar la orden");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}


	}
	
	
	
	public void addDelivery(Order orden) throws NoDatabaseConnection{
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			ArrayList <ArticleOrder> articles = orden.getArticles();
			Statement oStatement = con.createStatement();
			oStatement.execute("INSERT INTO pedido (Mesa_idMesa,Users_Username,Especificaciones,Estado) VALUES ("+orden.getTable().getNumero()+",'"+orden.getUser().getUsername()+"','"+orden.getSpec()+"','Delivery');");
			for(int i =0;i<articles.size();i++){
				ResultSet oResultSet1 = oStatement.executeQuery("SELECT ID FROM ARTICLES WHERE ARTICLES.NAME='"+articles.get(i).getArticle().getNombre()+"';");
				int nId= 0;
				while(oResultSet1.next()){
					nId = oResultSet1.getInt(1);
				}
				oStatement.execute("INSERT INTO `Pedido/Articulos` (pedido_idpedido, Articles_ID,Cantidad) VALUES (LAST_INSERT_ID(),"+nId+","+articles.get(i).getCantidad()+");");
			}

			oStatement.close();
			log.info("Orden agregada al delivery correctamente");
		}
		catch(SQLException e){
			log.error("Error al agregar pedido al delivery");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}


	}

	public void cambioEstadoOrder(Order o) throws NoDatabaseConnection{
		Connection con = null;
		try {
			String estado=defEstado(o.getEstado());
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("UPDATE Pedido SET `Estado` = '"+estado+"' WHERE Pedido.idpedido="+o.getId()+";");
			oStatement.close();
			log.info("El pedido "+o.getId()+" esta "+estado+".");

		} catch (SQLException e) {
			log.error("Error al cambiar el estado del pedido "+o.getId()+"");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}


	}
	
	public ArrayList<Order> getDeliverys() throws NoDatabaseConnection {
		ArrayList<Order> toReturn = new ArrayList<Order>();
		ArticleOrderDAO aOdao =ArticleOrderDAO.getInstance();
		TableDAO tDAO = TableDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		Connection con = null;
		try {
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Pedido Where (Estado = 'Delivery'); ");

			while (oResultSet.next()) {
				int nid = oResultSet.getInt(1);
				Date date = oResultSet.getTimestamp(2);
				int nIdmesa = oResultSet.getInt(3);
				String sEstado = oResultSet.getString(4);
				String sUsername = oResultSet.getString(6);
				String specs = oResultSet.getString(7);
				ArrayList<ArticleOrder> articles = aOdao.getArticleOrder(nid, con);
				Table t = tDAO.searchTable(nIdmesa,con);
				User u = uDAO.searchUser(sUsername,con);

				int estado=defEstado(sEstado);
				Order a = new Order(nid,articles,t,u,estado,specs,date);
				toReturn.add(a);
			}

			oResultSet.close();
			oStatement.close();
			log.info("Lista de todos los deliverys entregada");
		}
			 catch (SQLException e) {
				 log.error("Error al levantar lista de deliverys");
				throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
		return toReturn;
	}


	public ArrayList<Order> getOrders() throws NoDatabaseConnection {
		ArrayList<Order> toReturn = new ArrayList<Order>();
		ArticleOrderDAO aOdao =ArticleOrderDAO.getInstance();
		TableDAO tDAO = TableDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		Connection con = null;
		try {
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Pedido Where (Estado = 'En Preparacion'); ");

			while (oResultSet.next()) {
				int nid = oResultSet.getInt(1);
				Date date = oResultSet.getTimestamp(2);
				int nIdmesa = oResultSet.getInt(3);
				String sEstado = oResultSet.getString(4);
				String sUsername = oResultSet.getString(6);
				String specs = oResultSet.getString(7);
				ArrayList<ArticleOrder> articles = aOdao.getArticleOrder(nid, con);
				Table t = tDAO.searchTable(nIdmesa,con);
				User u = uDAO.searchUser(sUsername,con);

				int estado=defEstado(sEstado);
				Order a = new Order(nid,articles,t,u,estado,specs,date);
				toReturn.add(a);
			}

			oResultSet.close();
			oStatement.close();
			log.info("Entregada lista de todos los pedidos");
		}
			 catch (SQLException e) {
				 log.error("Error al levantar lista de todos los pedidos");
				throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
		return toReturn;
	}

	public ArrayList<Order> getTableOrders(Table t) throws NoDatabaseConnection {
		ArrayList<Order> toReturn = new ArrayList<Order>();
		ArticleOrderDAO aOdao =ArticleOrderDAO.getInstance();
		TableDAO tDAO = TableDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		Connection con = null;

		try {
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Pedido Where (Mesa_idMesa="+t.getNumero()+") AND ((Estado = 'Entregado') OR (Estado = 'En Preparacion') OR (Estado = 'Delivery'))");

			while (oResultSet.next()) {
				int nid = oResultSet.getInt(1);
				Date date = oResultSet.getTimestamp(2);
				int nIdmesa = oResultSet.getInt(3);
				String sEstado = oResultSet.getString(4);
				String sUsername = oResultSet.getString(6);
				String specs = oResultSet.getString(7);
				ArrayList<ArticleOrder> articles = aOdao.getArticleOrder(nid, con);
				Table ta = tDAO.searchTable(nIdmesa, con);
				User u = uDAO.searchUser(sUsername, con);

				int estado=defEstado(sEstado);

				Order a = new Order(nid,articles,ta,u,estado,specs,date);
				toReturn.add(a);
			}

			oResultSet.close();
			oStatement.close();
			log.info("Obtenidas las ordenes de la mesa "+t.getNumero()+"");
		}
			 catch (SQLException e) {
				 log.error("Error al obtener ordenes de mesa "+t.getNumero()+"");
				throw new NoDatabaseConnection("No hay conexion con la base de datos");
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				log.error("Error al finalizar la conexion con la base de datos");
				throw new NoDatabaseConnection("No hay conexion con la base de datos");
			}

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
		else if(e.equals("Cerrado")){
			estado = 3;
		}
		else if(e.equals("Delivery")){
			estado = 4;
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
		case 3: estado="Cerrado";
			break;
		case 4: estado="Delivery";

		default:
			estado=null;
			break;
		}
		return estado;
		}

	}


