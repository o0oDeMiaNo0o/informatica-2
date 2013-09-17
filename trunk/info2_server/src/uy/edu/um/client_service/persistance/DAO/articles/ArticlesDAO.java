package uy.edu.um.client_service.persistance.DAO.articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uy.edu.um.client_service.persistance.*;

public class ArticlesDAO {
	
	JDBC database = new JDBC();

	public ArticlesDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void addArticle(int id,String nom, int precio){
		try{
			Statement oStatement = database.getConnection().createStatement();
			oStatement.execute("INSERT INTO ARTICLES VALUES("+id+",'"+nom+"',"+precio+")");
			oStatement.close();
			database.closeConnection();
		}
		catch(SQLException e){
			e.printStackTrace();
			database.closeConnection();
		}

	}
	
	public void getArticles() {

		try {

			Statement oStatement = database.getConnection().createStatement();

			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				int nId = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				int nPrice = oResultSet.getInt(3);

				System.out.println("Article. ID: " + nId + " Nombre: " + sName + " Precio: " + nPrice);
				database.closeConnection();
			}

			oResultSet.close();
			oStatement.close();

		} catch (SQLException e) {
			database.closeConnection();
			throw new RuntimeException(e);
			
		}
	
	

}
}
