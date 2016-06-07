package br.com.al.jho.cadastro;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.al.jho.cadastro.ConnectionFactory;

public class TestaConexao {

	public static void main(String args[]) {
		Connection connection = ConnectionFactory.getConnection();
	     System.out.println("Conexão aberta!");
	     try {
			connection.close();
			System.out.println("Conexão fechada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
