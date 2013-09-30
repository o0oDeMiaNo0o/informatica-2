package uy.edu.um.client_service.persistance.DAO.users;

import java.sql.SQLException;
import java.sql.Statement;

import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.JDBC;

public class UserDAO {

	private static UserDAO instance = null;
	private JDBC database = JDBC.getInstance();
	
	
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
		

	}
	


