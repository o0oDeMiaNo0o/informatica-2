package uy.edu.um.client_service.persistance.DAO.deliveryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.JDBC;
import uy.edu.um.client_service.persistance.DAO.articleOrderDAO.ArticleOrderDAO;
import uy.edu.um.client_service.persistance.DAO.users.UserDAO;

public class DeliveryDAO {
	
	private static DeliveryDAO instance = null;

	JDBC database = JDBC.getInstance();


	//obtener instancia
	public static DeliveryDAO getInstance(){
		if (instance == null){
			instance = new DeliveryDAO();
		}
		return instance;
	}
	
	public void addDelivery(Delivery d){
		try{
			int enCocina=0;
			
			if(d.isEnCocina()){
				enCocina=1;
			}
			
			ArrayList <ArticleOrder> articles = d.getArticles();
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO delivery (Users_Username,Especificaciones,EnCocina) VALUES ('"+d.getUser().getUsername()+"','"+d.getSpecs()+"',"+enCocina+");");
		

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
			System.out.println("Delivery agregada correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}
	
	public ArrayList<Delivery> getDeliverys() {
		ArrayList<Delivery> toReturn = new ArrayList<Delivery>();
		ArticleOrderDAO aOdao =ArticleOrderDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		
		try {
			Statement oStatement = database.getConnection().createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Delivery");

			while (oResultSet.next()) {
				int nid = oResultSet.getInt(1);
				Date date = oResultSet.getTimestamp(2);
				String sEstado = oResultSet.getString(3);
				String sUsername = oResultSet.getString(5);
				String specs=oResultSet.getString(6);
				int enCocina = oResultSet.getInt(7);
				
				boolean cocina = false;
				
				if(enCocina==1){
					cocina=true;
				}

				
				ArrayList<ArticleOrder> articles = aOdao.getArticleOrder(nid);
				User u = uDAO.searchUser(sUsername);
				
				int estado=defEstado(sEstado);
				
				Delivery d = new Delivery(nid,articles,u,date,specs,estado,cocina);
				toReturn.add(d);
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
	
	public void cambioEstadoDelivery(Delivery o){
		try {
			String estado=defEstado(o.getEstado());
			
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("UPDATE Delivery SET `Estado` = '"+estado+"' WHERE Delivery.idDelivery="+o.getId()+";");
			oStatement.close();
			database.closeConnection();
			// Consola
			System.out.println("El delivery "+o.getId()+" esta "+estado+".");
			
		} catch (SQLException e) {
			e.printStackTrace();
			database.closeConnection();
		}
		
		
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
		return estado;
	}
	
	


}
