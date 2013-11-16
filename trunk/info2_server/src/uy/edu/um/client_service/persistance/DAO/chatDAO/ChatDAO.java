package uy.edu.um.client_service.persistance.DAO.chatDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.chat.entities.Chat;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;


public class ChatDAO {

	private static ChatDAO instance = null;
	
	public static ChatDAO getInstance(){
		if (instance == null){
			instance = new ChatDAO();
		}
		return instance;
	}
	
	public void addMsj(Chat c)throws NoDatabaseConnection{
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement o = con.createStatement();
			int coc = 0;
			if(c.isCocina()){
				coc=1;
			}
			o.execute("INSERT INTO `Info2`.`Chat`(`Mensaje`,`EnCocina`,`Estado`)VALUES('"+c.getMsj()+"',"+coc+",'Activo');");
			o.close();
		}
		catch(SQLException e){
			throw new NoDatabaseConnection("No hay conexion con la base de datos");
		}
		finally{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}

			}
		}
	}
	
	public void setEntregado(Chat c)throws NoDatabaseConnection{
		Connection con = null;
		try{
		con = DatabaseConnectionMgr.getInstance().getConnection();
		Statement oStatement = con.createStatement();
		oStatement.execute("UPDATE Chat SET `Estado` = 'Entregado' WHERE Mensaje='"+c.getMsj()+"';");
		oStatement.close();
		}
		catch(SQLException e){
			throw new NoDatabaseConnection("no hay conexion con la base de datos");
		}
		finally{
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new NoDatabaseConnection ("No hay conexion con la base de datos");
				}

			}
		}
		
	}
	
	public ArrayList<Chat> getChat() throws NoDatabaseConnection{
		Connection connection=null;
		try {
			ArrayList<Chat> toReturn = new ArrayList<Chat>();
			connection= DatabaseConnectionMgr.getInstance().getConnection();
			Statement oStatement = connection.createStatement();

			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM Chat Where Estado = 'Activo';");
			boolean enCocina=false;
			while (oResultSet.next()) {

				String msj = oResultSet.getString(1);
				int enC = oResultSet.getInt(2);
				if(enC==1){
					enCocina=true;
				}
				
				Chat c = new Chat(msj,enCocina);
				toReturn.add(c);
			}

			oResultSet.close();
			oStatement.close();
			return toReturn;
		}
		
		catch (SQLException e) {
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

		
		
	}
}
