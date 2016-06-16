package br.com.al.jho.cadastro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constants.Constants;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String id; // = new ArrayList<String>();
	String linguagem; // = new ArrayList<String>();
	String paradigmas; // = new ArrayList<String>();
	String habilidades; // = new ArrayList<String>();
	String certificacao;
	String anos;
	String email;

	public Download() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Connection connection = ConnectionFactory.getConnection();
		HttpSession session = request.getSession();
		
		session = request.getSession(true);
		//tentando pegar o usuario e email da sessão
		String emailUsr = (String) session.getAttribute("email");
		String receb = "";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(Constants.SQLQUERY);
			
			//stmt.executeQuery(emailUsr);
			ResultSet result = stmt.executeQuery();
			
			//result.get
			
			System.out.println("Começou!");
			while (result.next()){				
				id = result.getString("id");
				linguagem = result.getString("linguagem");
				paradigmas = result.getString("paradigmas");
				habilidades = result.getString("habilidades");
				certificacao = result.getString("certificacao");
				anos = result.getString("anos_exp");
				email = result.getString("email");
			}
			
			receb = id + "\n" + linguagem +
					"\n" + paradigmas + "\n" + habilidades + "\n"
					+ certificacao + "\n" + anos + "\n" + email + "\n";
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File("questionario.txt");
		
		OutputStream out = new FileOutputStream(file);
		
		//while()
		out.write(id.charAt(0));
		
		int cont = 0;
		while(cont < receb.length()){
			out.write(receb.charAt(cont++));
		}
		System.out.println("Terminou!");
		//out.flush();
		out.close();
		
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
