package uy.edu.um.client_service.persistance.DAO.order;

public class ClientDAO {

	private static ClientDAO instance = null;

	private ClientDAO(){};

	public static ClientDAO getInstance(){
		if (instance == null){
			instance = new ClientDAO();
		}
		return instance;
	}
	
	
}
