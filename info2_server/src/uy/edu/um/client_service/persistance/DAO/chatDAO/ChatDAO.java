package uy.edu.um.client_service.persistance.DAO.chatDAO;

import java.sql.Connection;
import java.sql.Statement;

import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;


public class ChatDAO {

	private static ChatDAO instance = null;
	
	public static ChatDAO getInstance(){
		if (instance == null){
			instance = new ChatDAO();
		}
		return instance;
	}
	
	public void addMsj(Chat c){
		Connection con = null;
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			Statement o = con.createStatement();
			int coc = 0;
			if(c.cocina){
				coc=1;
			}
			o.execute("INSERT INTO `Info2`.`Chat`(`Mensaje`,`EnCocina`,`Estado`)VALUES('"+c+"',);")
			
		}
	}
}
