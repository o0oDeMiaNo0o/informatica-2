package uy.edu.um.client_service.persistance.DAO.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class UserDAO {

	private static UserDAO instance = null;
	private final static Logger log = Logger.getLogger(UserDAO.class);

	private UserDAO(){}

	public static UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}

	//Eliminar usuario y cambiar contrase–a.

	public void addUser(User usuario) throws NoDatabaseConnection{
		Connection con = null;
		try{
			int adm = 0;
			if (usuario.isAdmin()){
				adm = 1;
			}
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("INSERT INTO USERS (USERNAME, PASSWORD, ADMIN) " +
					"VALUES ('"+usuario.getUsername()+"','"+usuario.getPassword()+"','"+adm+"');");
			oStatement.close();
			log.info("Usuario "+usuario.getUsername()+" agregado al sistema");
		}
		catch(SQLException e){
			log.error("Error al agregar usuario");
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

	public User searchUser(String Username) throws NoDatabaseConnection{
		Connection con = null;
		try {
			con = DatabaseConnectionMgr.getInstance().getConnection();
			return searchUser(Username, con);
		} catch (SQLException e) {
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		} finally{
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

	public User searchUser(String Username, Connection oConnection) throws NoDatabaseConnection{
		User u = null;
		try {

			Statement oStatement = oConnection.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Users` where `Users`.`Username` = '"+Username+"';");

			while(oResultSet.next()){
				boolean adm=false;
				String nPass = oResultSet.getString(3);
				int nAdm = oResultSet.getInt(4);

				if(nAdm==1){
					adm=true;
				}

				u = new User(Username,nPass,adm);
			}
			oResultSet.close();
			oStatement.close();
		}
		catch (SQLException e) {
			log.error("Error al buscar el usuario "+Username+"");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}

		return u;
	}

	public ArrayList<Boolean> checkUser(User u) throws NoDatabaseConnection{
		Connection con = null;
		ArrayList<Boolean> checked = new ArrayList<Boolean>();

		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Users` where (`Users`.`Username` = '"+u.getUsername()+"') AND (`Vigente`='Activo');");

			while(oResultSet.next()){
				boolean pass=false;
				boolean adm= false;
				String sPass = oResultSet.getString(2);
				int nAdm = oResultSet.getInt(3);

				if(sPass.equals(u.getPassword())){
					pass=true;
				}
				if(nAdm==1){
					adm=true;
				}
				checked.add(pass);
				checked.add(adm);
			}
			oResultSet.close();
			oStatement.close();

		}
		catch(SQLException e){
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

		return checked;
	}
	
	public void deleteUser(User u) throws NoDatabaseConnection{
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			oStatement.execute("UPDATE Users set Vigente = 'Eliminada' Where Users.Username = '"+u.getUsername()+"';");
			oStatement.close();
			log.info("El usuario "+u.getUsername()+" fue eliminado");
		}
		catch(SQLException e){
			log.error("Error al eliminar el usuario "+u.getUsername()+"");
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

	public ArrayList<User> allUsers() throws NoDatabaseConnection {
		Connection con = null;
		try {
			con = DatabaseConnectionMgr.getInstance().getConnection();
			ArrayList<User> toReturn = new ArrayList<User>();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Users WHERE `Vigente` = 'Activo'");

			while (oResultSet.next()) {
				boolean admi = false;
				String sUname = oResultSet.getString(2);
				String sPass = oResultSet.getString(3);
				int adm = oResultSet.getInt(4);

				if(adm==1){
					admi=true;
				}

				User u = new User(sUname,sPass,admi);
				toReturn.add(u);
			}

			oResultSet.close();
			oStatement.close();
			log.info("Lista de usuarios entregada");
			return toReturn;
		}
		catch (SQLException e) {
			log.error("Error al retirar lista de usuarios de la BD");
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

	public boolean checkUsername(String username) throws NoDatabaseConnection{
		boolean check = false;
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT Username FROM `Users` where (`Users`.`Username` = '"+username+"') AND (`Vigente`='Activo');");
			while(oResultSet.next()){
				check = true;
			}
			oResultSet.close();
			oStatement.close();
		}
		catch(SQLException e){
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
		return check;
	}

	public boolean checklogin(String username, String psw) throws NoDatabaseConnection{
		boolean check = false;
		Connection con=null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT Username, Password FROM `Users` where (`Users`.`Username` = '"+username+"') AND (`Vigente`='Activo');");

			while(oResultSet.next()){
				String password = oResultSet.getString(2);
				if(psw.equals(password)==true){
					check = true;
				}
			}
			oResultSet.close();
			oStatement.close();
			if(check){
				log.info("Usuario "+username+" fue logueado");
			}
			return check;
		}
		catch(SQLException e){
			log.error("Error al chequear el logueo del un usuario");
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
}




