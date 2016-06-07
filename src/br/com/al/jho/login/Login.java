package br.com.al.jho.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		String button = (String) request.getAttribute("logout");

		if (user.equals("jho") && email.equals("jho@email.com")) {
			HttpSession session = request.getSession();
			session.setAttribute("jho", "jho123");
			response.sendRedirect("/project01-dsw/Questionario");
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Error");
			dispatcher.forward(request, response);
		}

	}

}
