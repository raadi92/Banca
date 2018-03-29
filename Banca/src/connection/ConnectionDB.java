package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	String driver = "sun.jdbc.sqlite.JdbcSqLiteDriver";
	//	Class.forName(driver);
	String url = "jdbc:sqlite:C:/sqlite/db/Test.db";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public ConnectionDB() {
	}

	public void  openConnetion() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConnetion() {
		try {
			connection.close();
			statement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  void stampaTutto() throws SQLException {
		/*
		 * restituisce tutti i valori iban, nome ,saldo e idi 
		 * della tabella cc
		 */

		openConnetion();
		String query ="SEECT iban, nome ,saldo ,idi FROM  cc;";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getString("iban"));
			System.out.println(resultSet.getString("nome"));
			System.out.println(resultSet.getDouble("saldo"));
			System.out.println(resultSet.getInt("idi"));
		}
		resultSet.close();
		closeConnetion();
	}
}

