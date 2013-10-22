package uy.edu.um.client_service.persistance.DAO.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.JDBC;

public class UserDAO {

	private static UserDAO instance = null;
	private JDBC database = JDBC.getInstance();

	private UserDAO(){}

	public static UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}


		public void addUser(User usuario){
			try{
				int adm = 0;
				if (usuario.isAdmin()){
					adm = 1;
				}
				Statement oStatement = database.getConnection().createStatement();
				oStatement.execute("INSERT INTO USERS (USERNAME, PASSWORD, ADMIN) " +
						"VALUES ("+usuario.getUsername()+",'"+usuario.getPassword()+"',"+adm+");");
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
		
		public User searchUser(String Username){
			User u = null;
			try {
				Statement oStatement = database.getConnection().createStatement();
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
				database.closeConnection();
				throw new RuntimeException(e);
			}
			return u;
		}
		
		
		
		



	}



