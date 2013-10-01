package uy.edu.um.client_service.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private static JDBC instance = null;

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String JDBC_USER = "root";

	private static final String JDBC_PASSWORD = "";

	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Info2";

	private Connection connection  = null;

	private JDBC(){

	}

	public static JDBC getInstance(){

		if(instance==null){
			instance = new JDBC();
		}

		return instance;
	}

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

}
