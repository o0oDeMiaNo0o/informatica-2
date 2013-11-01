package uy.edu.um.client_service.persistance.DAO.deliveryDAO;

import uy.edu.um.client_service.persistance.JDBC;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.client_service.persistance.DAO.order.OrderDAO;

public class DeliveryDAO extends  {
	
	private static DeliveryDAO instance = null;

	JDBC database = JDBC.getInstance();


	//obtener instancia
	public static DeliveryDAO getInstance(){
		if (instance == null){
			instance = new DeliveryDAO();
		}
		return instance;
	}
	
	


}
