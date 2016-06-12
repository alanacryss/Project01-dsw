package br.com.al.jho.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constants.Constants;
import br.com.al.jho.cadastro.ConnectionFactory;

/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("jho") != null) {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<head>");
			out.println("<title>DSW 01</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"index\">");
			out.println("<div>");
			out.println("<form action=\"/project01-dsw/UserCreate\" method=\"POST\">");
			out.println("Nome: </br> <input type=\"text\" name=\"usr\" required size=\"20\"><br />");
			out.println("Email: </br> <input type=\"email\" name=\"email\" required size=\"20\"><br />");
			out.println("</br>");
			out.println("<input type=\"submit\" value=\"Salvar\">");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

			out.close();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Constants.SQLLOGIN);
			
			preparedStatement.setString(1, request.getParameter("usr"));
			preparedStatement.setString(2, request.getParameter("email"));
			
			preparedStatement.execute();
			
			connection.close();
			
			System.out.println("Dados inseridos!");
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<head>");
			out.println("<title>DSW 01</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Cadastrado com sucesso!</h1>");
			out.println("<a href=\"/project01-dsw/Questionario\" align=\"right\">Voltar</a>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
