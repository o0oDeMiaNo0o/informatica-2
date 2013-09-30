package uy.edu.um.client_service.persistance.DAO.clients;

import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.clients.entities.Client;
import uy.edu.um.client_service.persistance.JDBC;

public class ClientDAO {
	
	private JDBC database = JDBC.getInstance();

	private static ClientDAO instance = null;

	private ClientDAO(){};

	public static ClientDAO getInstance(){
		if (instance == null){
			instance = new ClientDAO();
		}
		return instance;
	}
	
	public void addClient(Client cliente){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO CLIENTES (CI, NOMBRE, APELLIDO, MAIL, DIRECCION, TELEFONO) " +
					"VALUES ("+cliente.getCi()+",'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getMail()+"','"+cliente.getDireccion()+"',"+cliente.getTel()+");");
			oStatement.close();
			database.closeConnection();
			//Verificacion por consola
			System.out.println("Cliente agregado correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}


	}
	
	
	
	
}
