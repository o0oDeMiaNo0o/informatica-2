package uy.edu.um.client_service.persistance.DAO.clients;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class ClientDAO {

	private static ClientDAO instance = null;
	private final static Logger log = Logger.getLogger(ClientDAO.class);

	private ClientDAO(){};

	public static ClientDAO getInstance(){
		if (instance == null){
			instance = new ClientDAO();
		}
		return instance;
	}

	public void addClient(Client cliente) throws NoDatabaseConnection{
		Connection connection = null;
		log.info("Agregando cliente");
		try{
			connection = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();
			oStatement.execute("INSERT INTO CLIENTES (CI, NOMBRE, APELLIDO, MAIL, DIRECCION, TELEFONO, DESCUENTO) " +
					"VALUES ("+cliente.getCi()+",'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getMail()+"','"+cliente.getDireccion()+"',"+cliente.getTel()+",'"+cliente.getDescuento()+"');");
			oStatement.close();
			log.info("Cliente agregado correctamente");
		}
		catch(SQLException e){
			log.error("Error al agregar cliente");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {

				try {

					connection.close();

				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}
		}
		}
	}



	public ArrayList<Client> getClients() throws NoDatabaseConnection{
		Connection connection = null;
		log.info("Retirando la lista de todos los clientes");
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
			log.info("Lista retirada con exito");
			return toReturn;
		}
			 catch (SQLException e) {
				 log.error("Error al retirar la lista de clientes");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("Error al finalizar la conexion con la base de datos");
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}
		}
		}

	}

	public boolean existeCliente(String nombre, int ci) throws NoDatabaseConnection{
		boolean check = false;
		Connection connection = null;
		log.info("Chequeando la existencia de el cliente "+nombre+"");
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
		
			}
		catch(SQLException e){
			log.error("Error al chequear existencia de cliente "+nombre+"");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}
			}
		}
		return check;

	}

}
