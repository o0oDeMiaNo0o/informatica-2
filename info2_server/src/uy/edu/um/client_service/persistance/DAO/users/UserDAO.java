package uy.edu.um.client_service.persistance.DAO.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class UserDAO {

	private static UserDAO instance = null;
	private Connection con = null;

	private UserDAO(){}

	public static UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}

	//Eliminar usuario y cambiar contrase–a.

	public void addUser(User usuario){
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
			//Verificacion por consola
			System.out.println("Cliente agregado correctamente");
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

	public User searchUser(String Username) throws NoDatabaseConnection{
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
					throw new RuntimeException(e);
				}
			}
		}

	}

	public User searchUser(String Username, Connection oConnection){
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
			throw new RuntimeException(e);
		}

		return u;
	}

	public ArrayList<Boolean> checkUser(User u){
		// Devuelve un ArrayList de booleans. El 1er elemento es si usuario y contrase–a estan bien, el 2do
		// indica si es administrador o no
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
			throw new RuntimeException(e);
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

		return checked;
	}

	public ArrayList<User> allUsers() {
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
			return toReturn;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
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

	public boolean checkUsername(String username){
		boolean check = false;
		try{
			Connection con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = con.createStatement();
			ResultSet oResultSet = oStatement.executeQuery("SELECT Username FROM `Users` where (`Users`.`Username` = '"+username+"') AND (`Vigente`='Activo');");
			while(oResultSet.next()){
				check = true;
			}
			oResultSet.close();
			oStatement.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
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
		return check;
	}

	public boolean checklogin(String username, String psw){
		boolean check = false;
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
			return check;
		}
		catch(SQLException e){
			throw new RuntimeException(e);
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
}




