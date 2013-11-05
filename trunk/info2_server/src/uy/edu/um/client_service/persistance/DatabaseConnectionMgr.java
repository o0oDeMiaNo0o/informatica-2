package uy.edu.um.client_service.persistance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DatabaseConnectionMgr {

	private DataSource datasource = null;

	private static DatabaseConnectionMgr instance = null;

	private DatabaseConnectionMgr() {
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileInputStream("datasource.properties"));
			datasource = BasicDataSourceFactory.createDataSource(propiedades);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DatabaseConnectionMgr getInstance() {
		if (instance == null) {
			instance = new DatabaseConnectionMgr();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
}