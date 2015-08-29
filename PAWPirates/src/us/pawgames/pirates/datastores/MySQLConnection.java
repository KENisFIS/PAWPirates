package us.pawgames.pirates.datastores;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private final String username = "mc6963";
	private final String password = "dc63e70dab";
	private final String url = "jdbc:mysql://localhost:3306/mc6963";
	public static Connection connection;
	
	public void connect() {
		try {
			if ((connection != null) && (!connection.isClosed())) {
				return;
			}
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if ((connection != null) && (connection.isClosed())) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		connect();
		return connection;
	}
}