package br.com.al.jho.cadastro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cadastro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String linguagem = request.getParameter("linguagem");
		String[] paradigmas = request.getParameterValues("paradigmas");
		String anosExp = request.getParameter("anos_exp");
		String cert = request.getParameter("certificacao");
		String habil = request.getParameter("habilidades");
		
		String sql = "insert into cadastro (linguagem,paradigmas,habilidades,anos_exp,certificacao) " +
				     "values (?,?,?,?,?)";
		
		String param = "";
		
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conexão aberta!");
		
		for (int i = 0; i < paradigmas.length; i++) {
			param += paradigmas[i] + "; ";
		}
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, linguagem);
			stmt.setString(2, param);
			stmt.setString(3, habil);
			stmt.setString(4, anosExp);
			stmt.setString(5, cert);
			
			stmt.execute();
			
			connection.close();
			
			System.out.println("Dados inseridos!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
