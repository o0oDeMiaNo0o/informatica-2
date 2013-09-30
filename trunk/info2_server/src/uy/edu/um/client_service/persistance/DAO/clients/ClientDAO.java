package uy.edu.um.client_service.persistance.DAO.clients;

import java.sql.ResultSet;
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
	
	public void getClients() {

		try {

			Statement oStatement = database.getConnection().createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM CLIENTES");

			while (oResultSet.next()) {

				int nId = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				String sApellido = oResultSet.getString(3);
				String sMail = oResultSet.getString(4);
				String sDir = oResultSet.getString(5);
				int ntel = oResultSet.getInt(6);
				
				System.out.println("Cient. Ci: " + nId +" Nombre: "+sName+ " " + sApellido + ". Mail: " + sMail+" Direccion: "+sDir+". Telefono:"+ntel);

			}

			oResultSet.close();
			oStatement.close();
			database.closeConnection();


		}
			 catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);

		}



}
	
	
	
	
}
