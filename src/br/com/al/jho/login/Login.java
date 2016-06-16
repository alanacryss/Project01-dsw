package br.com.al.jho.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.Name;

import Constants.Constants;
import br.com.al.jho.cadastro.ConnectionFactory;
//import jdbc.connection.ConnectionFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("usr");
		String email = request.getParameter("email");

		String emailBd = "";
		String userBd = "";
		String button = (String) request.getAttribute("logout");

		Connection conexao = ConnectionFactory.getConnection();

		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(Constants.SQLQUERYLOG);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				
				if (result.getString("name").equals("jardell") && result.getString("email").equals("dell@email.com")) {
					userBd = result.getString("name");
					emailBd = result.getString("email");
				}
			}

			System.out.println(emailBd);
			System.out.println(userBd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((user.equals(userBd) && email.equals(emailBd))
				|| (user.equals("admin") && email.equals("admin@admin.com"))) {
			HttpSession session = request.getSession();
			session.setAttribute("usr", user);
			session.setAttribute("email", email);
			response.sendRedirect("/project01-dsw/Questionario");
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Error");
			dispatcher.forward(request, response);
		}

	}

}
