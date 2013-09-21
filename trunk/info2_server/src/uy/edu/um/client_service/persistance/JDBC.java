package uy.edu.um.client_service.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String JDBC_USER = "root";

	private static final String JDBC_PASSWORD = "";

	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Info2";

	private Connection connection  = null;

	public Connection getConnection() {
		if (connection == null) {

			try {

				// Registro del driver.

				Class.forName(JDBC_DRIVER);

			} catch (ClassNotFoundException e) {

				throw new RuntimeException(e);
			}

			try {

				connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			} catch (SQLException e) {

				throw new RuntimeException(e);
			}

		}

		return connection;
	}

	public void closeConnection() {

		if (connection != null) {

			try {

				connection.close();

				connection = null;

			} catch (SQLException e) {

				throw new RuntimeException(e);
			}

		}

	}

	public void createDatabase(){

		try {
		Statement oStatement = getConnection().createStatement();

		oStatement.execute("DROP TABLE ARTICLES");

		oStatement.execute("CREATE TABLE ARTICLES (ID INTEGER, NOMBRE VARCHAR(40), PRECIO INTEGER)");

		oStatement.close();


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public void getArticles() {

		try {

			Statement oStatement = getConnection().createStatement();

			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				int nId = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				int nPrice = oResultSet.getInt(3);

				System.out.println("Article. ID: " + nId + " Nombre: " + sName + " Precio: " + nPrice);

			}

			oResultSet.close();
			oStatement.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}



	public JDBC() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		JDBC db = new JDBC();
		
		try {
			Statement oStatement = db.getConnection().createStatement();
			oStatement.execute("INSERT INTO ARTICLES VALUES(123,'gjhgjh',120)");
			//oStatement.execute("INSERT INTO ARTICLES VALUES(12,'pancho',120)");
			//oStatement.execute("INSERT INTO ARTICLES VALUES(13,'chivito',120)");
			//oStatement.execute("INSERT INTO ARTICLES VALUES(14,'Receta de la casa',5000)");
			ResultSet oResultSet = oStatement.executeQuery("SELECT * FROM ARTICLES");

			while (oResultSet.next()) {

				int nId = oResultSet.getInt(1);
				String sName = oResultSet.getString(2);
				int nPrice = oResultSet.getInt(3);

				System.out.println("Article. ID: " + nId + " Nombre: " + sName + " Precio: " + nPrice);

			}

			oResultSet.close();
			oStatement.close();
			db.closeConnection();

			
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
