package br.com.al.jho.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String pathdb = "jdbc:postgresql://localhost:5432/dbproject";
	private static String user = "postgres";
	private static String pass = "asdf1357";

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(pathdb, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
