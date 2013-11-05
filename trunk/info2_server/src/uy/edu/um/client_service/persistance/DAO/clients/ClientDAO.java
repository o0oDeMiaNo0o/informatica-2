package uy.edu.um.client_service.persistance.DAO.clients;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;

public class ClientDAO {

	private Connection connection = null;
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
			connection = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();
			oStatement.execute("INSERT INTO CLIENTES (CI, NOMBRE, APELLIDO, MAIL, DIRECCION, TELEFONO, DESCUENTO) " +
					"VALUES ("+cliente.getCi()+",'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getMail()+"','"+cliente.getDireccion()+"',"+cliente.getTel()+",'"+cliente.getDescuento()+"');");
			oStatement.close();
			//Verificacion por consola
			System.out.println("Cliente agregado correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		}
	}



	public ArrayList<Client> getClients() {

		try {

			ArrayList<Client> toReturn = new ArrayList<Client>();
			
			connection = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();


			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Clientes");

			while (oResultSet.next()) {

				int nCli = oResultSet.getInt(1);
				int Ci = oResultSet.getInt(2);
				String sName = oResultSet.getString(3);
				String sApellido = oResultSet.getString(4);
				String sMail = oResultSet.getString(5);
				String sDir = oResultSet.getString(6);
				int tel = oResultSet.getInt(7);
				BigDecimal desc = oResultSet.getBigDecimal(8);

				Client c = new Client(nCli,sName,sApellido,Ci,tel,sDir,sMail,desc);
				toReturn.add(c);
			}

			oResultSet.close();
			oStatement.close();
			return toReturn;
		}
			 catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		}

	}

	public boolean existeCliente(String nombre, int ci){
		boolean check = false;
		try{
			connection = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `clientes` WHERE  " +
					"Nombre = '"+nombre+"';");
			while(oResultSet.next()){
				int ciTaken = oResultSet.getInt(2);
				if(ci == ciTaken){
					check = true;
				}
			}
			oStatement.close();
			System.out.println("Cliente agregado correctamente");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		}
		return check;
		
	}

}
