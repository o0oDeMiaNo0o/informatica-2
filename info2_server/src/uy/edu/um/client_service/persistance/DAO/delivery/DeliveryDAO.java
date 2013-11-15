package uy.edu.um.client_service.persistance.DAO.delivery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.client_service.persistance.DAO.deliveryOrderDAO.DeliveryOrderDAO;
import uy.edu.um.client_service.persistance.DAO.users.UserDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class DeliveryDAO {

	private static DeliveryDAO instance = null;

	//obtener instancia
	public static DeliveryDAO getInstance(){
		if (instance == null){
			instance = new DeliveryDAO();
		}
		return instance;
	}

	public void addDelivery(Delivery d){ 
		Connection con = null;
		try{
			int enCocina=0;
			if(d.isEnCocina()){
				enCocina=1;
			}

			ArrayList <ArticleOrder> articles = d.getArticles();
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("INSERT INTO delivery (Users_Username,Especificaciones,EnCocina) VALUES ('"+d.getUser().getUsername()+"','"+d.getSpecs()+"',"+enCocina+");");


			for(int i =0;i<articles.size();i++){
				ResultSet oResultSet1 = oStatement.executeQuery("SELECT ID FROM ARTICLES WHERE ARTICLES.NAME='"+articles.get(i).getArticle().getNombre()+"';");
				int nId= 0;
				while(oResultSet1.next()){
					nId = oResultSet1.getInt(1);
				}
				oStatement.execute("INSERT INTO `Delivery/Articulos` (Delivery_idDelivery, Articles_ID,Cantidad) VALUES (LAST_INSERT_ID(),"+nId+","+articles.get(i).getCantidad()+");");
			}

			oStatement.close();
			//Verificacion por consola
			System.out.println("Delivery agregada correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
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


	}

	public ArrayList<Delivery> getDeliverys() throws NoDatabaseConnection {
		ArrayList<Delivery> toReturn = new ArrayList<Delivery>();
		DeliveryOrderDAO dOdao = DeliveryOrderDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		Connection con = null;
		try {
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
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
				ArrayList<ArticleOrder> articles = dOdao.getDeliveryOrder(nid,con);
				User u = uDAO.searchUser(sUsername,con);
				int estado=defEstado(sEstado);
				Delivery d = new Delivery(nid,articles,u,date,specs,estado,cocina);
				toReturn.add(d);
			}

			oResultSet.close();
			oStatement.close();
		}
			 catch (SQLException e) {
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					throw new NoDatabaseConnection("No hay conexion con la base de datos");
				}
		}
		}
		return toReturn;
	}

	public void cambioEstadoDelivery(Delivery o) throws NoDatabaseConnection{
		Connection con = null;
		try {
			String estado=defEstado(o.getEstado());
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("UPDATE Delivery SET `Estado` = '"+estado+"' WHERE Delivery.idDelivery="+o.getId()+";");
			oStatement.close();
			// Consola
			System.out.println("El delivery "+o.getId()+" esta "+estado+".");

		} catch (SQLException e) {
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
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


	}

	public String defEstado(int e){
		String estado=null;
		switch(e){
		case 0: estado="En Preparacion";
			break;
		case 1: estado="En Viaje";
			break;
		case 2: estado="Rechazado";
			break;
		case 3: estado="En cola de espera";
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
		else if(e.equals("En Viaje")){
			estado = 1;
		}
		else if(e.equals("Rechazado")){
			estado = 2;
		}
		else if(e.equals("En cola de espera")){
			estado = 3;
		}
		return estado;
	}




}
