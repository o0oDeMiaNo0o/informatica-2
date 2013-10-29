package uy.edu.um.client_service.persistance.DAO.users;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.people.clients.entities.Client;
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
		
		public ArrayList<Boolean> checkUser(User u){
			// Devuelve un ArrayList de booleans. El 1er elemento es si usuario y contrase–a estan bien, el 2do 
			// indica si es administrador o no
			ArrayList<Boolean> checked = new ArrayList<Boolean>();
			
			try{
				Statement oStatement = database.getConnection().createStatement();
				ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM `Users` where `Users`.`Username` = '"+u.getUsername()+"';");
				
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
				database.closeConnection();				
				
			}
			catch(SQLException e){
				database.closeConnection();
				throw new RuntimeException(e);
				
			}
			return checked;
		}
		
		public ArrayList<User> getUsers() {

			try {

				ArrayList<User> toReturn = new ArrayList<User>();

				Statement oStatement = database.getConnection().createStatement();


				ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Users");

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
				database.closeConnection();
				return toReturn;
			}
				 catch (SQLException e) {
				database.closeConnection();
				throw new RuntimeException(e);


			}

		}
		
	}



